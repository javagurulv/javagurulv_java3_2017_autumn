package lv.javaguru.java3.integrations.rest.dto;

public class UserDTOBuilder {

    private Long id;
    private String login;
    private String password;
    private String email;

    private UserDTOBuilder() {

    }

    public static UserDTOBuilder createUserDTO() {
        return new UserDTOBuilder();
    }

    public UserDTO build() {
        UserDTO user = new UserDTO();
        user.setId(id);
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        return user;
    }

    public UserDTOBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public UserDTOBuilder withLogin(String login) {
        this.login = login;
        return this;
    }

    public UserDTOBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserDTOBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

}
