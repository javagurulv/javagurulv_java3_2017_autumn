package lv.javaguru.java3.core.services.clients;

import lv.javaguru.java3.core.database.ClientDAO;
import lv.javaguru.java3.core.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class ClientServiceImpl implements ClientService {

    @Autowired private ClientDAO clientDAO;
    @Autowired private ClientValidator clientValidator;


    @Override
    public User update(Long clientId,
                       String newLogin,
                       String newPassword) {
        clientValidator.validate(newLogin, newPassword);
        User user = get(clientId);
        user.setLogin(newLogin);
        user.setPassword(newPassword);
        return user;
    }

    @Override
    public User get(Long clientId) {
        return clientDAO.getRequired(clientId);
    }

}
