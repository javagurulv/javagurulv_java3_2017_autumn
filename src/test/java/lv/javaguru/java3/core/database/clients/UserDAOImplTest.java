package lv.javaguru.java3.core.database.clients;

import lv.javaguru.java3.core.domain.User;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import static lv.javaguru.java3.core.domain.builders.UserBuilder.createUser;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class UserDAOImplTest extends DatabaseHibernateTest {

    @Test
    @Transactional
    public void testCreateClient() {
        User user = createUser()
                .withLogin("login")
                .withPassword("password").build();
        assertThat(user.getId(), is(nullValue()));
        clientDAO.create(user);
        assertThat(user.getId(), is(notNullValue()));
    }

    @Test
    @Transactional
    public void testGetClientById() {
        User user = createUser()
                .withLogin("login")
                .withPassword("password").build();
        clientDAO.create(user);
        User userFromDb = clientDAO.getById(user.getId());
        assertThat(userFromDb, is(notNullValue()));
    }

}