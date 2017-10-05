package lv.javaguru.java3.integrations.rest.dto;

public class ClientDTOBuilder {

    private Long id;
    private String login;
    private String password;


    private ClientDTOBuilder() {

    }

    public static ClientDTOBuilder createClientDTO() {
        return new ClientDTOBuilder();
    }

    public ClientDTO build() {
        ClientDTO client = new ClientDTO();
        client.setId(id);
        client.setLogin(login);
        client.setPassword(password);
        return client;
    }

    public ClientDTOBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ClientDTOBuilder withLogin(String login) {
        this.login = login;
        return this;
    }

    public ClientDTOBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

}
