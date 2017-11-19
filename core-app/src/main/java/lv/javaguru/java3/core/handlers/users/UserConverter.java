package lv.javaguru.java3.core.handlers.users;

import lv.javaguru.java3.common.dtos.UserDTO;
import lv.javaguru.java3.core.domain.User;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3.common.dtos.UserDTOBuilder.createUserDTO;

@Component
class UserConverter {

    public UserDTO convert(User user) {
        return createUserDTO()
                .withId(user.getId())
                .withLogin(user.getLogin())
                .withPassword(user.getPassword())
                .withEmail(user.getEmail())
                .build();
    }

}
