package org.example.springmvcexample.request;


public class UserRequest {
    private final Long id;
    private final String name;
    private final String email;
    private final String password;

    public String getPassword() {
        return password;
    }

    public UserRequest(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
