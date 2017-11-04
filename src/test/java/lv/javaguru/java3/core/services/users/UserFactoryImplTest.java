package lv.javaguru.java3.core.services.users;

import lv.javaguru.java3.core.domain.User;
import lv.javaguru.java3.core.domain.repositories.UserRepository;
import lv.javaguru.java3.core.exceptons.ValidationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static lv.javaguru.java3.core.exceptons.ValidationExceptionBuilder.createValidationException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserFactoryImplTest {

    @Mock private UserValidator userValidator;
    @Mock private UserRepository userRepository;

    @InjectMocks
    private UserFactory userFactory = new UserFactoryImpl();

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email";


    @Test
    public void createShouldInvokeValidator() {
        userFactory.create(LOGIN, PASSWORD, EMAIL);
        verify(userValidator).validate(LOGIN, PASSWORD, EMAIL);
    }

    @Test(expected = ValidationException.class)
    public void createShouldFailIfValidationFail() {
        doThrow(createValidationException().build())
                .when(userValidator).validate(LOGIN, PASSWORD, EMAIL);
        userFactory.create(LOGIN, PASSWORD, EMAIL);
    }

    @Test
    public void createShouldPersistUserAfterValidation() {
        when(userRepository.save(Mockito.any(User.class))).then(returnsFirstArg());
        User user = userFactory.create(LOGIN, PASSWORD, EMAIL);
        InOrder inOrder = inOrder(userValidator, userRepository);
        inOrder.verify(userValidator).validate(LOGIN, PASSWORD, EMAIL);
        inOrder.verify(userRepository).save(user);
    }

    @Test
    public void createShouldReturnNewUser() {
        when(userRepository.save(Mockito.any(User.class))).then(returnsFirstArg());
        User user = userFactory.create(LOGIN, PASSWORD, EMAIL);
        assertThat(user.getLogin(), is(LOGIN));
        assertThat(user.getPassword(), is(PASSWORD));
        assertThat(user.getEmail(), is(EMAIL));
    }

}
