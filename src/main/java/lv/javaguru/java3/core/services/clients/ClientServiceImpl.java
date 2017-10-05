package lv.javaguru.java3.core.services.clients;

import lv.javaguru.java3.core.database.ClientDAO;
import lv.javaguru.java3.core.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class ClientServiceImpl implements ClientService {

    @Autowired private ClientDAO clientDAO;
    @Autowired private ClientValidator clientValidator;


    @Override
    public Client update(Long clientId,
                         String newLogin,
                         String newPassword) {
        clientValidator.validate(newLogin, newPassword);
        Client client = get(clientId);
        client.setLogin(newLogin);
        client.setPassword(newPassword);
        return client;
    }

    @Override
    public Client get(Long clientId) {
        return clientDAO.getRequired(clientId);
    }

}
