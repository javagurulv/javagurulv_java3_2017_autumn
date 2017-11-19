package lv.javaguru.java3.app.jms;

import lv.javaguru.java3.app.rest.DeferredResultHolder;
import lv.javaguru.java3.app.rest.exceptions.HttpStatusMapper;
import lv.javaguru.java3.core.api.exceptons.InternalServerException;
import lv.javaguru.java3.core.api.jms.JMSResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

public interface JMSResponseProcessor {
    void process(JMSResponse response);
}

@Component
class JMSResponseProcessorImpl implements JMSResponseProcessor {

    @Autowired private List<JMSResponseHandler> responseHandlers;
    @Autowired private DeferredResultHolder deferredResultHolder;
    @Autowired private HttpStatusMapper httpStatusMapper;

    @Override
    public void process(JMSResponse jmsResponse) {
        if (jmsResponse.isSuccess()) {
            processSuccessfulResponse(jmsResponse);
        } else {
            processFailedResponse(jmsResponse);
        }
    }

    private void processSuccessfulResponse(JMSResponse jmsResponse) {
        ResponseEntity responseEntity = responseHandlers.stream()
                .filter(ch -> ch.canProcess(jmsResponse))
                .findFirst()
                .orElseThrow(InternalServerException::new)
                .process(jmsResponse);
        process(jmsResponse, responseEntity);
    }

    private void processFailedResponse(JMSResponse jmsResponse) {
        process(jmsResponse,
                ResponseEntity
                        .status(httpStatusMapper.map(jmsResponse.getResponseStatus()))
                        .body(jmsResponse.getPayload())
        );
    }

    private void process(JMSResponse jmsResponse,
                         ResponseEntity responseEntity) {
        deferredResultHolder.get(jmsResponse.getCorrelationId())
                .orElseThrow(InternalServerException::new)
                .setResult(responseEntity);
    }

}
