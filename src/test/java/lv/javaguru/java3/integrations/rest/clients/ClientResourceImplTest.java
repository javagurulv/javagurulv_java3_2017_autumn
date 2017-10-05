package lv.javaguru.java3.integrations.rest.clients;

import lv.javaguru.java3.integrations.rest.RESTResourceTest;
import lv.javaguru.java3.integrations.rest.dto.ClientDTO;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;

import static lv.javaguru.java3.integrations.rest.dto.ClientDTOBuilder.createClientDTO;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ClientResourceImplTest extends RESTResourceTest {

    @Test
    public void createClientTest() {
        ClientDTO client = clientResource.create(
                createClientDTO()
                        .withLogin(RandomStringUtils.random(20))
                        .withPassword(RandomStringUtils.random(20)).build()
        );
        assertThat(client, is(notNullValue()));
        assertThat(client.getId(), is(notNullValue()));
    }

    @Test
    public void getClientTest() {
        ClientDTO newClient = clientResource.create(
                createClientDTO()
                        .withLogin(RandomStringUtils.random(20))
                        .withPassword(RandomStringUtils.random(20)).build()
        );
        ClientDTO oldClient = clientResource.get(newClient.getId());
        assertThat(newClient.getId(), is(oldClient.getId()));
        assertThat(newClient.getLogin(), is(oldClient.getLogin()));
        assertThat(newClient.getPassword(), is(oldClient.getPassword()));
    }

}
