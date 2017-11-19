package lv.javaguru.java3.core.api.jms.requests.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lv.javaguru.java3.common.dtos.UserDTO;
import lv.javaguru.java3.core.api.jms.SupportedCommandId;
import lv.javaguru.java3.core.api.jms.requests.JMSAPIRequest;

public class JMSRegisterUserRequest implements JMSAPIRequest {

    @JsonProperty("user")
    private UserDTO userDTO;


    @Override
    public String getCommandId() {
        return SupportedCommandId.REGISTER_USER;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
