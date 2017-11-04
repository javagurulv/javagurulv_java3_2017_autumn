package lv.javaguru.java3.integrations.rest;

import lv.javaguru.java3.common.dtos.UserDTO;
import lv.javaguru.java3.core.api.CommandExecutor;
import lv.javaguru.java3.core.api.users.GetUserCommand;
import lv.javaguru.java3.core.api.users.GetUserResult;
import lv.javaguru.java3.core.api.users.RegisterUserCommand;
import lv.javaguru.java3.core.api.users.RegisterUserResult;
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
