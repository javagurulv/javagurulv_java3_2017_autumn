package lv.javaguru.java3.core.jms;

import lv.javaguru.java3.core.api.jms.JMSQueues;
import lv.javaguru.java3.core.api.jms.JMSRequest;
import lv.javaguru.java3.core.api.jms.JMSResponse;
import lv.javaguru.java3.core.commons.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
class JMSRequestReceiver {

    @Autowired private JMSRequestExecutor jmsRequestExecutor;
    @Autowired private JsonMapper jsonMapper;
    @Autowired private JMSResponseSender jmsResponseSender;

    @JmsListener(destination = JMSQueues.PUBLIC_APP_REQUEST_QUEUE,
            concurrency = "${jms.client.request.listener.concurrency:10}")
    public void onMessage(TextMessage inMessage) throws JMSException {
        processRequest(inMessage);
    }

    protected void processRequest(TextMessage inMessage) throws JMSException {
        String messageText = inMessage.getText();
        JMSRequest request = jsonMapper.mapToObject(messageText, JMSRequest.class);
        JMSResponse response = jmsRequestExecutor.execute(request);
        jmsResponseSender.send(response, inMessage.getJMSCorrelationID());
    }

}
