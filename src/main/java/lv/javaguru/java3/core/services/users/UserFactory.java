package lv.javaguru.java3.core.services.users;

import lv.javaguru.java3.core.domain.User;
import lv.javaguru.java3.core.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3.core.domain.builders.UserBuilder.createUser;

public interface UserFactory {

    User create(String login,
                String password,
                String email);

}

@Component
class UserFactoryImpl implements UserFactory {

    @Autowired private UserValidator userValidator;
    @Autowired private UserRepository userRepository;

    @Override
    public User create(String login, String password, String email) {
        userValidator.validate(login, password, email);
        User user = createUser()
                .withLogin(login)
                .withPassword(password)
                .withEmail(email)
                .build();
        return userRepository.save(user);
    }

}
