package lv.javaguru.java3.core.services.clients;

import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.commons.lang.StringUtils.isBlank;

@Component
class ClientValidatorImpl implements ClientValidator {

    @Override
    public void validate(String login, String password) {
        validateLogin(login);
        validatePassword(password);
    }

    private void validateLogin(String login) {
        checkNotNull(login, "Client login must not be null");
        checkArgument(!isBlank(login), "Client login must not be empty");
    }

    private void validatePassword(String password) {
        checkNotNull(password, "Client password must not be null");
        checkArgument(!isBlank(password), "Client password must not be empty");
    }

}
