package lv.javaguru.java3.core.services.clients;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ClientValidatorImplTest {

    private ClientValidator validator = new ClientValidatorImpl();

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";


    @Test
    public void validateShouldFailIfLoginIsNull() {
        validateShouldFail(null, PASSWORD, "Client login must not be null");
    }

    @Test
    public void validateShouldFailIfPasswordIsNull() {
        validateShouldFail(LOGIN, null, "Client password must not be null");
    }

    @Test
    public void validateShouldFailIfLoginIsEmpty() {
        validateShouldFail("", PASSWORD, "Client login must not be empty");
    }

    @Test
    public void validateShouldFailIfPasswordIsEmpty() {
        validateShouldFail(LOGIN, "", "Client password must not be empty");
    }

    private void validateShouldFail(String login,
                                    String password,
                                    String errorMessage) {
        try {
            validator.validate(login, password);
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage(), is(errorMessage));
        }
    }

}
