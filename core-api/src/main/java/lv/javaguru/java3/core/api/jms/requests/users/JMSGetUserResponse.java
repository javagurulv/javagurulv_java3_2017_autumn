package lv.javaguru.java3.core.api.jms.requests.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lv.javaguru.java3.common.dtos.UserDTO;

public class JMSGetUserResponse {

    @JsonProperty("user")
    private UserDTO userDTO;


    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

}
