package lv.javaguru.java3.app.jms;

import lv.javaguru.java3.core.api.jms.JMSResponse;
import org.springframework.http.ResponseEntity;

public interface JMSResponseHandler {

    String getSupportedCommandId();

    default boolean canProcess(JMSResponse response) {
        return response.getCommandId().equals(getSupportedCommandId());
    }

    ResponseEntity process(JMSResponse jmsResponse);

}
