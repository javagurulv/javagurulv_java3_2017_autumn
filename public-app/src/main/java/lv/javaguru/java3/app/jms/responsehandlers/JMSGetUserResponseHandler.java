package lv.javaguru.java3.app.jms.responsehandlers;

import lv.javaguru.java3.app.common.JsonMapper;
import lv.javaguru.java3.app.jms.JMSResponseHandler;
import lv.javaguru.java3.core.api.jms.JMSResponse;
import lv.javaguru.java3.core.api.jms.SupportedCommandId;
import lv.javaguru.java3.core.api.jms.requests.users.JMSGetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
class JMSGetUserResponseHandler implements JMSResponseHandler {

    @Autowired private JsonMapper jsonMapper;

    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.GET_USER;
    }

    @Override
    public ResponseEntity process(JMSResponse jmsResponse) {
        String payload = jmsResponse.getPayload();
        JMSGetUserResponse response = jsonMapper.mapToObject(
                payload, JMSGetUserResponse.class
        );
        return ResponseEntity.ok(response.getUserDTO());
    }

}
