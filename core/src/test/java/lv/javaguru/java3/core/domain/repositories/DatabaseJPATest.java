package lv.javaguru.java3.core.domain.repositories;

import lv.javaguru.java3.core.configs.DatabaseConfiguration;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = DatabaseConfiguration.class)
public abstract class DatabaseJPATest {

	@Autowired
	protected UserRepository userRepository;

}
