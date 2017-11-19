package lv.javaguru.java3.app.jms;

import lv.javaguru.java3.app.rest.DeferredResultBuilder;
import lv.javaguru.java3.app.rest.DeferredResultHolder;
import lv.javaguru.java3.core.api.jms.JMSRequest;
import lv.javaguru.java3.core.api.jms.requests.JMSAPIRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

public interface JMSRequestProcessor {

    DeferredResult<ResponseEntity> process(JMSAPIRequest request);

}

@Component
class JMSRequestProcessorImpl implements JMSRequestProcessor {

    @Autowired private JMSRequestBuilder jmsRequestBuilder;
    @Autowired private DeferredResultBuilder deferredResultBuilder;
    @Autowired private DeferredResultHolder deferredResultHolder;
    @Autowired private JMSRequestSender jmsRequestSender;

    @Override
    public DeferredResult<ResponseEntity> process(JMSAPIRequest request) {
        JMSRequest jmsRequest = jmsRequestBuilder.build(request);
        DeferredResult<ResponseEntity> deferredResult = deferredResultBuilder.build();
        deferredResultHolder.put(jmsRequest, deferredResult);
        jmsRequestSender.send(jmsRequest);
        return deferredResult;
    }

}
