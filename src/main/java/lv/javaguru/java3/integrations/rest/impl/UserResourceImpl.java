package lv.javaguru.java3.integrations.rest.impl;

import lv.javaguru.java3.core.commands.users.GetUserCommand;
import lv.javaguru.java3.core.commands.users.GetUserResult;
import lv.javaguru.java3.core.commands.users.RegisterUserCommand;
import lv.javaguru.java3.core.commands.users.RegisterUserResult;
import lv.javaguru.java3.core.services.CommandExecutor;
import lv.javaguru.java3.integrations.rest.api.RESTResource;
import lv.javaguru.java3.integrations.rest.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = RESTResource.API_PATH)
public class UserResourceImpl {

    @Autowired private CommandExecutor commandExecutor;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) {
        RegisterUserCommand command = new RegisterUserCommand(userDTO);
        RegisterUserResult result = commandExecutor.execute(command);
        return ResponseEntity.ok(result.getUser());
    }

    @RequestMapping(value = "/users/{login}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> get(@PathVariable("login") String login) {
        GetUserCommand command = new GetUserCommand(login);
        GetUserResult result = commandExecutor.execute(command);
        return ResponseEntity.ok(result.getUser());
    }

}
