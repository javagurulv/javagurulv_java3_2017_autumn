package lv.javaguru.java3.core.database.clients;

import lv.javaguru.java3.core.domain.repositories.UserRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public abstract class DatabaseJPATest {

	@Autowired
	protected UserRepository userRepository;

}
