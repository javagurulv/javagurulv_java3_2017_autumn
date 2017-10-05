package lv.javaguru.java3.core.commands.clients;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.integrations.rest.dto.ClientDTO;

public class UpdateClientResult implements DomainCommandResult {

    private ClientDTO client;

    public UpdateClientResult(ClientDTO client) {
        this.client = client;
    }

    public ClientDTO getClient() {
        return client;
    }

}
