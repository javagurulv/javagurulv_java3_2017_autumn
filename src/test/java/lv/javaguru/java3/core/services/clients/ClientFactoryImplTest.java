package lv.javaguru.java3.core.services.clients;

import lv.javaguru.java3.core.database.ClientDAO;
import lv.javaguru.java3.core.domain.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ClientFactoryImplTest {

    @Mock private ClientValidator clientValidator;
    @Mock private ClientDAO clientDAO;

    @InjectMocks
    private ClientFactory clientFactory = new ClientFactoryImpl();

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";


    @Test
    public void createShouldInvokeValidator() {
        clientFactory.create(LOGIN, PASSWORD);
        verify(clientValidator).validate(LOGIN, PASSWORD);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createShouldFailIfValidationFail() {
        doThrow(new IllegalArgumentException())
                .when(clientValidator).validate(LOGIN, PASSWORD);
        clientFactory.create(LOGIN, PASSWORD);
    }

    @Test
    public void createShouldPersistClientAfterValidation() {
        Client client = clientFactory.create(LOGIN, PASSWORD);
        InOrder inOrder = inOrder(clientValidator, clientDAO);
        inOrder.verify(clientValidator).validate(LOGIN, PASSWORD);
        inOrder.verify(clientDAO).create(client);
    }

    @Test
    public void createShouldReturnNewClient() {
        Client client = clientFactory.create(LOGIN, PASSWORD);
        assertThat(client.getLogin(), is(LOGIN));
        assertThat(client.getPassword(), is(PASSWORD));
    }

}
