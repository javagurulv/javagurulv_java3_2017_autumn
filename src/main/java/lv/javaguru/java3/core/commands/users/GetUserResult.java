package lv.javaguru.java3.core.commands.users;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.integrations.rest.dto.UserDTO;

public class GetUserResult implements DomainCommandResult {

    private UserDTO user;

    public GetUserResult(UserDTO user) {
        this.user = user;
    }

    public UserDTO getUser() {
        return user;
    }
}
