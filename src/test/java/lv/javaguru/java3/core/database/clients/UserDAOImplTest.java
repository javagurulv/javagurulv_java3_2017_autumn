package lv.javaguru.java3.core.database.clients;

import lv.javaguru.java3.core.domain.User;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static lv.javaguru.java3.core.domain.builders.UserBuilder.createUser;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class UserDAOImplTest extends DatabaseJPATest {

    @Test
    @Transactional
    public void testSaveUser() {
        User user = createUser()
                .withLogin("login")
                .withPassword("password")
                .withEmail("email").build();
        assertThat(user.getId(), is(nullValue()));
        user = userRepository.save(user);
        assertThat(user.getId(), is(notNullValue()));
    }

    @Test
    @Transactional
    public void testFindOneByLogin() {
        Optional<User> userFromDb = userRepository.findOneByLogin("not-existing-login");
        assertThat(userFromDb.isPresent(), is(false));
    }

    @Test
    @Transactional
    public void testGetRequiredByLogin() {
        User user = createUser()
                .withLogin("login")
                .withPassword("password")
                .withEmail("email").build();
        userRepository.save(user);
        User userFromDb = userRepository.getRequiredByLogin(user.getLogin());
        assertThat(userFromDb, is(notNullValue()));
    }

}