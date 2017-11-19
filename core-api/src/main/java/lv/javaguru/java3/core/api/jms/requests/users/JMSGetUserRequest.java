package lv.javaguru.java3.core.api.jms.requests.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lv.javaguru.java3.core.api.jms.SupportedCommandId;
import lv.javaguru.java3.core.api.jms.requests.JMSAPIRequest;

public class JMSGetUserRequest implements JMSAPIRequest {

    @JsonProperty("user_login")
    private String userLogin;

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public String getCommandId() {
        return SupportedCommandId.GET_USER;
    }
}
