package lv.javaguru.java3.core.jms;

import lv.javaguru.java3.core.api.jms.JMSQueues;
import lv.javaguru.java3.core.api.jms.JMSResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

public interface JMSResponseSender {
    void send(JMSResponse response, String correlationId);
}

@Component
class JMSResponseSenderImpl implements JMSResponseSender {

    @Autowired private JmsTemplate jmsTemplate;
    @Autowired private ResponseMessageBuilder responseMessageBuilder;

    @Override
    public void send(JMSResponse response, String correlationId) {
        jmsTemplate.send(JMSQueues.PUBLIC_APP_RESPONSE_QUEUE, session ->
                responseMessageBuilder.build(session, response, correlationId)
        );
    }
}
