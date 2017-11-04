package lv.javaguru.java3.core.services.users;

public interface UserValidator {

    void validate(String login,
                  String password,
                  String email);

}
