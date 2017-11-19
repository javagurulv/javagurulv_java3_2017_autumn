package lv.javaguru.java3.core.services.users;

import lv.javaguru.java3.core.domain.User;
import lv.javaguru.java3.core.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public interface UserService {

    User get(String login);

}

@Component
class UserServiceImpl implements UserService {

    @Autowired private UserRepository userRepository;

    @Override
    public User get(String login) {
        return userRepository.getRequiredByLogin(login);
    }

}
