package lv.javaguru.java3.app.rest;

import lv.javaguru.java3.core.api.jms.JMSRequest;
import org.slf4j.Logger;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.slf4j.LoggerFactory.getLogger;

public interface DeferredResultHolder {
    void put(JMSRequest jmsRequest, DeferredResult<ResponseEntity> result);
    Optional<DeferredResult<ResponseEntity>> get(String correlationId);
}

@Component
class DeferredResultHolderImpl implements DeferredResultHolder {

    private static final Logger log = getLogger(DeferredResultHolder.class);

    private final ConcurrentMap<String, DeferredResultWrapper> resultMap = new ConcurrentHashMap<>();


    @Override
    public void put(JMSRequest jmsRequest,
                    DeferredResult<ResponseEntity> deferredResult) {
        DeferredResultWrapper wrapper = new DeferredResultWrapper(jmsRequest, deferredResult);
        this.resultMap.put(jmsRequest.getCorrelationId(), wrapper);
        deferredResult.onTimeout(() -> this.onTimeout(wrapper));
        deferredResult.onCompletion(() -> this.onCompletion(wrapper));
    }

    @Override
    public Optional<DeferredResult<ResponseEntity>> get(String correlationId) {
        DeferredResultWrapper wrapper = this.resultMap.get(correlationId);
        return  wrapper == null ? Optional.empty() : Optional.of(wrapper.getDeferredResult());
    }

    private void onTimeout(DeferredResultWrapper wrapper) {
        log.warn("Request timed out. CORRELATION-ID: {}.", wrapper.getJMSRequest().getCorrelationId());
    }

    private void onCompletion(DeferredResultWrapper wrapper) {
        resultMap.remove(wrapper.getJMSRequest().getCorrelationId());
    }

    @EventListener({ContextClosedEvent.class})
    private void gracefulShutdown() throws InterruptedException {
        CountDownLatch cacheIsEmptyLatch = new CountDownLatch(1);
        new Thread(() -> {
            while (!resultMap.isEmpty()) {
                try {
                    log.info("Waiting for all pending requests to process or timeout. Requests left: {}", resultMap.size());
                    Thread.sleep(1000L);
                } catch (InterruptedException ignored) { }
            }
            cacheIsEmptyLatch.countDown();
        }).start();
        cacheIsEmptyLatch.await(10000L, TimeUnit.MILLISECONDS);
    }
}


class DeferredResultWrapper {

    private JMSRequest jmsRequest;
    private DeferredResult<ResponseEntity> deferredResult;

    DeferredResultWrapper(JMSRequest jmsRequest,
                          DeferredResult<ResponseEntity> deferredResult) {
        this.jmsRequest = jmsRequest;
        this.deferredResult = deferredResult;
    }

    JMSRequest getJMSRequest() {
        return jmsRequest;
    }

    DeferredResult<ResponseEntity> getDeferredResult() {
        return deferredResult;
    }

}
