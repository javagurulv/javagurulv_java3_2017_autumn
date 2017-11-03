package lv.javaguru.java3.core.commands.clients;

import lv.javaguru.java3.core.domain.User;
import lv.javaguru.java3.integrations.rest.dto.ClientDTO;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3.integrations.rest.dto.ClientDTOBuilder.createClientDTO;

@Component
class ClientConverter {

    public ClientDTO convert(User user) {
        return createClientDTO()
                .withId(user.getId())
                .withLogin(user.getLogin())
                .withPassword(user.getPassword()).build();
    }


}
