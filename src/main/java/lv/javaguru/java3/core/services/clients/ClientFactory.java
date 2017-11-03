package lv.javaguru.java3.core.services.clients;

import lv.javaguru.java3.core.domain.User;

public interface ClientFactory {

    User create(String login, String password);

}
