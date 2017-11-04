package lv.javaguru.java3.core.commands.users;

import lv.javaguru.java3.core.domain.User;
import lv.javaguru.java3.integrations.rest.dto.UserDTO;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3.integrations.rest.dto.UserDTOBuilder.createUserDTO;

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
