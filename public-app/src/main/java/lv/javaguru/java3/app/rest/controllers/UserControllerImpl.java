package lv.javaguru.java3.app.rest.controllers;

import lv.javaguru.java3.app.jms.JMSRequestProcessor;
import lv.javaguru.java3.common.dtos.UserDTO;
import lv.javaguru.java3.core.api.jms.requests.users.JMSGetUserRequest;
import lv.javaguru.java3.core.api.jms.requests.users.JMSRegisterUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping("/api")
public class UserControllerImpl {

    @Autowired private JMSRequestProcessor jmsRequestProcessor;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public DeferredResult<ResponseEntity> register(@RequestBody UserDTO userDTO) {
        JMSRegisterUserRequest jmsRequest = new JMSRegisterUserRequest();
        jmsRequest.setUserDTO(userDTO);
        return jmsRequestProcessor.process(jmsRequest);
    }

    @RequestMapping(value = "/users/{login}", method = RequestMethod.GET)
    public DeferredResult<ResponseEntity> get(@PathVariable("login") String login) {
        JMSGetUserRequest jmsRequest = new JMSGetUserRequest();
        jmsRequest.setUserLogin(login);
        return jmsRequestProcessor.process(jmsRequest);
    }

}
