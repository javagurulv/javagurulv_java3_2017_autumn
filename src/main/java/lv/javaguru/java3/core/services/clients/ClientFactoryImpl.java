package lv.javaguru.java3.core.services.clients;

import lv.javaguru.java3.core.database.ClientDAO;
import lv.javaguru.java3.core.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3.core.domain.ClientBuilder.createClient;

@Component
class ClientFactoryImpl implements ClientFactory {

    @Autowired private ClientValidator clientValidator;
    @Autowired private ClientDAO clientDAO;


    @Override
    public Client create(String login, String password) {
        clientValidator.validate(login, password);
        Client client = createClient()
                .withLogin(login)
                .withPassword(password)
                .build();
        clientDAO.create(client);
        return client;
    }

}
