package org.example.springmvcexample.controller;

import org.example.springmvcexample.request.LoginRequest;
import org.example.springmvcexample.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/login")
    public String login(LoginRequest request, Model model) {
        String id = request.getId();
        String password = request.getPassword();
        boolean isLogin = authService.login(id, password);
        model.addAttribute("isLogin", isLogin);
        model.addAttribute("id", id);
        return "login-success";
    }
}
