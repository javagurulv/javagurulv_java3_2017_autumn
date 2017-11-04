package lv.javaguru.java3.core.domain.repositories;

import lv.javaguru.java3.core.domain.User;
import lv.javaguru.java3.core.exceptons.ResponseStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import static lv.javaguru.java3.core.exceptons.ValidationErrorBuilder.createValidationError;
import static lv.javaguru.java3.core.exceptons.ValidationExceptionBuilder.createValidationException;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByLogin(String login);

    default User getRequiredByLogin(String login) {
        return findOneByLogin(login)
                .orElseThrow(() -> createValidationException(ResponseStatus.NOT_FOUND)
                        .with(createValidationError()
                                .withField("login")
                                .withErrorCode("invalid.value")).build());
    }

}
