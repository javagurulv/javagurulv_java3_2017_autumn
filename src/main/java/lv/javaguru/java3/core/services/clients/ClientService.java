package lv.javaguru.java3.core.services.clients;

import lv.javaguru.java3.core.domain.User;


public interface ClientService {

    User update(Long clientId,
                String newLogin,
                String newPassword);

    User get(Long clientId);

}
