package lv.javaguru.java3.core.services.users;

import com.google.common.collect.Lists;
import lv.javaguru.java3.core.ValidationExceptionMatches;
import lv.javaguru.java3.core.api.common.ResponseStatus;
import lv.javaguru.java3.core.api.exceptons.ValidationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static lv.javaguru.java3.core.api.exceptons.ValidationErrorBuilder.createValidationError;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class UserValidatorImplTest {

    @Mock private EmailValidator emailValidator;
    @Mock private LoginValidator loginValidator;

    @InjectMocks
    private UserValidator validator = new UserValidatorImpl();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email";

    @Test
    public void shouldSucceed() {
        doReturn(true).when(emailValidator).isValid(EMAIL);
        doReturn(Lists.newArrayList()).when(loginValidator).validate(LOGIN);

        validator.validate(LOGIN, PASSWORD, EMAIL);
    }

    @Test
    public void shouldFailWhenLoginIsNull() {
        doReturn(true).when(emailValidator).isValid(EMAIL);
        doReturn(Lists.newArrayList(createValidationError()
                    .withField("login")
                    .withErrorCode("empty.field").build()))
                .when(loginValidator).validate(null);

        exception.expect(ValidationException.class);
        exception.expect(ValidationExceptionMatches.validationException(
                ResponseStatus.BAD_REQUEST,
                createValidationError()
                        .withField("login")
                        .withErrorCode("empty.field").build()));

        validator.validate(null, PASSWORD, EMAIL);
    }

}
