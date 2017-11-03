package lv.javaguru.java3.core.database.clients;

import lv.javaguru.java3.core.database.ClientDAO;
import lv.javaguru.java3.core.domain.User;
import org.springframework.stereotype.Component;

@Component
class ClientDAOImpl extends CRUDOperationDAOImpl<User, Long> implements ClientDAO {

}
