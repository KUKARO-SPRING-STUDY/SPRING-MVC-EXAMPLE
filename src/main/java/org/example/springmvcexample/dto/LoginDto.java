package org.example.springmvcexample.dto;

public class LoginDto {
    private final boolean isLogin;
    private final String id;

    public LoginDto(boolean isLogin, String id) {
        this.isLogin = isLogin;
        this.id = id;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public String getId() {
        return id;
    }
}
