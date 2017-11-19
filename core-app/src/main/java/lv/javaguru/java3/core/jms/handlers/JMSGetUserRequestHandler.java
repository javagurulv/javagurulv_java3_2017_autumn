package lv.javaguru.java3.core.jms.handlers;

import lv.javaguru.java3.core.api.jms.JMSRequest;
import lv.javaguru.java3.core.api.jms.SupportedCommandId;
import lv.javaguru.java3.core.api.jms.requests.users.JMSGetUserRequest;
import lv.javaguru.java3.core.api.jms.requests.users.JMSGetUserResponse;
import lv.javaguru.java3.core.commands.users.GetUserCommand;
import lv.javaguru.java3.core.commands.users.GetUserResult;
import lv.javaguru.java3.core.jms.JMSRequestHandler;
import org.springframework.stereotype.Component;

@Component
class JMSGetUserRequestHandler extends JMSRequestHandler {

    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.GET_USER;
    }

    @Override
    public String process(JMSRequest request) {
        JMSGetUserRequest jmsCommand = mapRequest(request, JMSGetUserRequest.class);

        GetUserCommand coreCommand = new GetUserCommand(jmsCommand.getUserLogin());
        GetUserResult coreResult = executeCoreCommand(coreCommand);

        JMSGetUserResponse jmsResponse = new JMSGetUserResponse();
        jmsResponse.setUserDTO(coreResult.getUser());
        return buildPayload(jmsResponse);
    }

}
