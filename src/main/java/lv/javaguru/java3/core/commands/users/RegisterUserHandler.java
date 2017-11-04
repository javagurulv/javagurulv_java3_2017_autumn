package lv.javaguru.java3.core.commands.users;

import lv.javaguru.java3.core.services.DomainCommandHandler;
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
