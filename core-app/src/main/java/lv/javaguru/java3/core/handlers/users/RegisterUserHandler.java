package lv.javaguru.java3.core.handlers.users;

import lv.javaguru.java3.common.dtos.UserDTO;
import lv.javaguru.java3.core.commands.users.RegisterUserCommand;
import lv.javaguru.java3.core.commands.users.RegisterUserResult;
import lv.javaguru.java3.core.domain.User;
import lv.javaguru.java3.core.handlers.DomainCommandHandler;
import lv.javaguru.java3.core.services.users.UserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class RegisterUserHandler implements DomainCommandHandler<RegisterUserCommand, RegisterUserResult> {

    @Autowired private UserFactory userFactory;
    @Autowired private UserConverter userConverter;

    @Override
    public RegisterUserResult execute(RegisterUserCommand command) {
        User user = userFactory.create(
                command.getUserDTO().getLogin(),
                command.getUserDTO().getPassword(),
                command.getUserDTO().getEmail()
        );

        UserDTO userDTO = userConverter.convert(user);
        return new RegisterUserResult(userDTO);
    }

    @Override
    public Class getCommandType() {
        return RegisterUserCommand.class;
    }
}
