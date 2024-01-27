package org.example.springmvcexample.controller;

import org.example.springmvcexample.dto.UserDto;
import org.example.springmvcexample.entity.User;
import org.example.springmvcexample.request.UserRequest;
import org.example.springmvcexample.response.UserResponse;
import org.example.springmvcexample.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        User user = userService.saveUser(new User(userRequest.getId(), userRequest.getEmail(), userRequest.getName()));
        UserDto userDto = new UserDto(user.getId(), user.getName(), user.getEmail());
        return new UserResponse("SUCCESS", List.of(userDto));
    }

    @GetMapping("/users")
    public UserResponse showUsers() {
        List<User> users = userService.findAllUser();
        List<UserDto> userDtos = users.stream().map(user -> new UserDto(user.getId(), user.getName(), user.getEmail())).toList();
        return new UserResponse("SUCCESS", userDtos);
    }

    @DeleteMapping("/users")
    public UserResponse deleteUsers() {
        userService.deleteAllUser();
        return new UserResponse("SUCCESS", List.of());
    }
}
