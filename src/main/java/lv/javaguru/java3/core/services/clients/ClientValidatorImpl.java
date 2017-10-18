package lv.javaguru.java3.core.services.clients;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@Component
class ClientValidatorImpl implements ClientValidator {

    @Override
    public void validate(String login, String password) {
        validateLogin(login);
        validatePassword(password);
    }

    private void validateLogin(String login) {
        checkNotNull(login, "Client login must not be null");
        checkArgument(!StringUtils.isEmpty(login), "Client login must not be empty");
    }

    private void validatePassword(String password) {
        checkNotNull(password, "Client password must not be null");
        checkArgument(!StringUtils.isEmpty(password), "Client password must not be empty");
    }

}
