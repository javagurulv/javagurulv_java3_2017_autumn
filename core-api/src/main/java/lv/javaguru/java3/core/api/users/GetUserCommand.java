package lv.javaguru.java3.core.api.users;

import lv.javaguru.java3.core.api.DomainCommand;

public class GetUserCommand implements DomainCommand<GetUserResult> {

    private String login;

    public GetUserCommand(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}
