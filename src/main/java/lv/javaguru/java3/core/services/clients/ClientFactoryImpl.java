package lv.javaguru.java3.core.services.clients;

import lv.javaguru.java3.core.database.ClientDAO;
import lv.javaguru.java3.core.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3.core.domain.builders.UserBuilder.createUser;

@Component
class ClientFactoryImpl implements ClientFactory {

    @Autowired private ClientValidator clientValidator;
    @Autowired private ClientDAO clientDAO;


    @Override
    public User create(String login, String password) {
        clientValidator.validate(login, password);
        User user = createUser()
                .withLogin(login)
                .withPassword(password)
                .build();
        clientDAO.create(user);
        return user;
    }

}
