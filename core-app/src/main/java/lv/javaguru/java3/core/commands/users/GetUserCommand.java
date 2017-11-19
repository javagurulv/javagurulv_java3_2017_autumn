package lv.javaguru.java3.core.commands.users;

import lv.javaguru.java3.core.commands.DomainCommand;

public class GetUserCommand implements DomainCommand<GetUserResult> {

    private String login;

    public GetUserCommand(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}
