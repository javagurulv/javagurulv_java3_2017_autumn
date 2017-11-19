package lv.javaguru.java3.app.jms.responsehandlers;

import lv.javaguru.java3.app.common.JsonMapper;
import lv.javaguru.java3.app.jms.JMSResponseHandler;
import lv.javaguru.java3.core.api.jms.JMSResponse;
import lv.javaguru.java3.core.api.jms.SupportedCommandId;
import lv.javaguru.java3.core.api.jms.requests.users.JMSRegisterUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
class JMSRegisterUserResponseHandler implements JMSResponseHandler {

    @Autowired private JsonMapper jsonMapper;

    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.REGISTER_USER;
    }

    @Override
    public ResponseEntity process(JMSResponse jmsResponse) {
        String payload = jmsResponse.getPayload();
        JMSRegisterUserResponse response = jsonMapper.mapToObject(
                payload, JMSRegisterUserResponse.class
        );
        return ResponseEntity.ok(response.getUserDTO());
    }

}
