package lv.javaguru.java3.core.handlers.users;

import lv.javaguru.java3.common.dtos.UserDTO;
import lv.javaguru.java3.core.api.users.GetUserCommand;
import lv.javaguru.java3.core.api.users.GetUserResult;
import lv.javaguru.java3.core.domain.User;
import lv.javaguru.java3.core.handlers.DomainCommandHandler;
import lv.javaguru.java3.core.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class GetUserCommandHandler
        implements DomainCommandHandler<GetUserCommand, GetUserResult> {

    @Autowired private UserService userService;
    @Autowired private UserConverter userConverter;

    @Override
    public GetUserResult execute(GetUserCommand command) {
        User user = userService.get(command.getLogin());
        UserDTO userDTO = userConverter.convert(user);
        return new GetUserResult(userDTO);
    }

    @Override
    public Class getCommandType() {
        return GetUserCommand.class;
    }

}
