package lv.javaguru.java3.core.commands.users;

import lv.javaguru.java3.common.dtos.UserDTO;
import lv.javaguru.java3.core.commands.DomainCommandResult;

public class GetUserResult implements DomainCommandResult {

    private UserDTO user;

    public GetUserResult(UserDTO user) {
        this.user = user;
    }

    public UserDTO getUser() {
        return user;
    }
}
