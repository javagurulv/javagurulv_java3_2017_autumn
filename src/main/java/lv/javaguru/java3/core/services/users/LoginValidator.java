package lv.javaguru.java3.core.services.users;

import lv.javaguru.java3.core.domain.User;
import lv.javaguru.java3.core.domain.repositories.UserRepository;
import lv.javaguru.java3.core.exceptons.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static lv.javaguru.java3.core.exceptons.ValidationErrorBuilder.createValidationError;

public interface LoginValidator {
    List<ValidationError> validate(String login);
}

@Component
class LoginValidatorImpl implements LoginValidator {

    private static final int LOGIN_MIN_LENGTH = 5;
    private static final int LOGIN_MAX_LENGTH = 20;

    @Autowired private UserRepository userRepository;

    @Override
    public List<ValidationError> validate(String login) {
        List<ValidationError> errors = new ArrayList<>();
        if (isEmpty(login)) {
            errors.add(createValidationError()
                    .withField("login")
                    .withErrorCode("empty.field").build());
        } else {
            validateMinLength(login).ifPresent(errors::add);
            validateMaxLength(login).ifPresent(errors::add);
            validateUniqueness(login).ifPresent(errors::add);
        }
        return errors;
    }

    private boolean isEmpty(String login) {
        return StringUtils.isEmpty(login);
    }

    private Optional<ValidationError> validateMinLength(String login) {
        if(login.length() < LOGIN_MIN_LENGTH) {
            return Optional.of(createValidationError()
                    .withField("login")
                    .withErrorCode("invalid.value")
                    .withDescription("Min length must be at least 5 characters").build());
        } else {
            return Optional.empty();
        }
    }

    private Optional<ValidationError> validateMaxLength(String login) {
        if(login.length() > LOGIN_MAX_LENGTH) {
            return Optional.of(createValidationError()
                    .withField("login")
                    .withErrorCode("invalid.value")
                    .withDescription("Max length must be at least 20 characters").build());
        } else {
            return Optional.empty();
        }
    }

    private Optional<ValidationError> validateUniqueness(String login) {
        Optional<User> alreadyExistingUser = userRepository.findOneByLogin(login);
        if(alreadyExistingUser.isPresent()) {
            return Optional.of(createValidationError()
                    .withField("login")
                    .withErrorCode("invalid.value")
                    .withDescription("User with login already exist").build());
        } else {
            return Optional.empty();
        }
    }

}
