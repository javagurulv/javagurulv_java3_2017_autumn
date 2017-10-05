package lv.javaguru.java3.core.services.clients;

import lv.javaguru.java3.core.domain.Client;

public interface ClientFactory {

    Client create(String login, String password);

}
