package lv.javaguru.java3.core.commands.users;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.integrations.rest.dto.UserDTO;

public class RegisterUserResult implements DomainCommandResult {

    private UserDTO user;

    public RegisterUserResult(UserDTO user) {
        this.user = user;
    }

    public UserDTO getUser() {
        return user;
    }

}
