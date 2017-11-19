package lv.javaguru.java3.core.jms.handlers;

import lv.javaguru.java3.core.api.jms.JMSRequest;
import lv.javaguru.java3.core.api.jms.SupportedCommandId;
import lv.javaguru.java3.core.api.jms.requests.users.JMSRegisterUserRequest;
import lv.javaguru.java3.core.api.jms.requests.users.JMSRegisterUserResponse;
import lv.javaguru.java3.core.commands.users.RegisterUserCommand;
import lv.javaguru.java3.core.commands.users.RegisterUserResult;
import lv.javaguru.java3.core.jms.JMSRequestHandler;
import org.springframework.stereotype.Component;

@Component
class JMSRegisterUserRequestHandler extends JMSRequestHandler {

    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.REGISTER_USER;
    }

    @Override
    public String process(JMSRequest request) {
        JMSRegisterUserRequest jmsCommand = mapRequest(request, JMSRegisterUserRequest.class);

        RegisterUserCommand coreCommand = new RegisterUserCommand(jmsCommand.getUserDTO());
        RegisterUserResult coreResult = executeCoreCommand(coreCommand);

        JMSRegisterUserResponse jmsResponse = new JMSRegisterUserResponse();
        jmsResponse.setUserDTO(coreResult.getUser());
        return buildPayload(jmsResponse);
    }

}
