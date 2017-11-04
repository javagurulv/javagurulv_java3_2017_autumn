package lv.javaguru.java3.core.services.users;

import lv.javaguru.java3.core.exceptons.ResponseStatus;
import lv.javaguru.java3.core.exceptons.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static lv.javaguru.java3.core.exceptons.ValidationErrorBuilder.createValidationError;
import static lv.javaguru.java3.core.exceptons.ValidationExceptionBuilder.createValidationException;

@Component
class UserValidatorImpl implements UserValidator {

    @Autowired private EmailValidator emailValidator;
    @Autowired private LoginValidator loginValidator;

    @Override
    public void validate(String login,
                         String password,
                         String email) {
        List<ValidationError> errors = new ArrayList<>();
        errors.addAll(validateLogin(login));
        validatePassword(password).ifPresent(errors::add);
        validateEmail(email).ifPresent(errors::add);
        if (!errors.isEmpty()) {
            throw createValidationException(ResponseStatus.BAD_REQUEST)
                    .with(errors).build();
        }
    }

    private List<ValidationError> validateLogin(String login) {
        return loginValidator.validate(login);
    }

    private Optional<ValidationError> validatePassword(String password) {
        if(StringUtils.isEmpty(password)) {
            return Optional.of(createValidationError()
                    .withField("password")
                    .withErrorCode("empty.field").build());
        } else {
            return Optional.empty();
        }
    }

    private Optional<ValidationError> validateEmail(String email) {
        if(StringUtils.isEmpty(email)) {
            return Optional.of(createValidationError()
                    .withField("email")
                    .withErrorCode("empty.field").build());
        }

        if (!emailValidator.isValid(email)) {
            return Optional.of(createValidationError()
                    .withField("email")
                    .withErrorCode("invalid.value").build());
        }

        return Optional.empty();
    }

}
