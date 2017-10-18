package lv.javaguru.java3.integrations.rest.impl;

import lv.javaguru.java3.core.commands.clients.CreateClientCommand;
import lv.javaguru.java3.core.commands.clients.CreateClientResult;
import lv.javaguru.java3.core.commands.clients.GetClientCommand;
import lv.javaguru.java3.core.commands.clients.GetClientResult;
import lv.javaguru.java3.core.services.CommandExecutor;
import lv.javaguru.java3.integrations.rest.api.RESTResource;
import lv.javaguru.java3.integrations.rest.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = RESTResource.API_PATH)
public class ClientResourceImpl  {

    @Autowired private CommandExecutor commandExecutor;


    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public ResponseEntity<ClientDTO> create(@RequestBody ClientDTO clientDTO) {
        CreateClientCommand command = new CreateClientCommand(
                clientDTO.getLogin(), clientDTO.getPassword()
        );
        CreateClientResult result = commandExecutor.execute(command);
        return ResponseEntity.ok(result.getClient());
    }

    @RequestMapping(value = "/clients/{clientId}", method = RequestMethod.GET)
    public ResponseEntity<ClientDTO> get(@PathVariable("clientId") Long clientId) {
        GetClientCommand command = new GetClientCommand(clientId);
        GetClientResult result = commandExecutor.execute(command);
        return ResponseEntity.ok(result.getClient());
    }

}
