package lv.javaguru.java3.core.jms;

import lv.javaguru.java3.core.api.jms.JMSResponse;
import lv.javaguru.java3.core.commons.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

public interface ResponseMessageBuilder {
    TextMessage build(Session session,
                      JMSResponse response,
                      String jmsCorrelationId) throws JMSException;
}

@Component
class ResponseMessageBuilderImpl implements ResponseMessageBuilder {

    @Autowired private JsonMapper jsonMapper;

    private static final Long JMS_REQUEST_TIMEOUT = 5000L;

    @Override
    public TextMessage build(Session session,
                             JMSResponse response,
                             String jmsCorrelationId) throws JMSException {
        String responseMessage = jsonMapper.mapToString(response);
        TextMessage outMessage = session.createTextMessage(responseMessage);
        outMessage.setJMSCorrelationID(jmsCorrelationId);
        outMessage.setJMSExpiration(JMS_REQUEST_TIMEOUT);
        return outMessage;
    }

}
