package lv.javaguru.java3.core.handlers.users;

import lv.javaguru.java3.core.api.users.RegisterUserCommand;
import lv.javaguru.java3.core.api.users.RegisterUserResult;
import lv.javaguru.java3.core.handlers.DomainCommandHandler;
import org.springframework.stereotype.Component;

@Component
class RegisterUserHandler implements DomainCommandHandler<RegisterUserCommand, RegisterUserResult> {

    @Override
    public RegisterUserResult execute(RegisterUserCommand command) {
        return null;
    }

    @Override
    public Class getCommandType() {
        return RegisterUserCommand.class;
    }
}
