package lv.javaguru.java3.core.commands.clients;

import lv.javaguru.java3.core.domain.Client;
import lv.javaguru.java3.integrations.rest.dto.ClientDTO;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3.integrations.rest.dto.ClientDTOBuilder.createClientDTO;

@Component
class ClientConverter {

    public ClientDTO convert(Client client) {
        return createClientDTO()
                .withId(client.getId())
                .withLogin(client.getLogin())
                .withPassword(client.getPassword()).build();
    }


}
