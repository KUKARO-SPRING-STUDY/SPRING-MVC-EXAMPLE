package org.example.springmvcexample.response;

import org.example.springmvcexample.dto.UserDto;

import java.util.List;

public class UserResponse {
    private final String status;
    private final List<UserDto> data;

    public UserResponse(String status, List<UserDto> data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public List<UserDto> getData() {
        return data;
    }
}
