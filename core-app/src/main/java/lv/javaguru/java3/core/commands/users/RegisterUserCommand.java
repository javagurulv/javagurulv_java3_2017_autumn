package lv.javaguru.java3.core.commands.users;

import lv.javaguru.java3.common.dtos.UserDTO;
import lv.javaguru.java3.core.commands.DomainCommand;

public class RegisterUserCommand implements DomainCommand<RegisterUserResult> {

    private UserDTO userDTO;

    public RegisterUserCommand(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }
}
