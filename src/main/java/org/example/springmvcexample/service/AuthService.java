package org.example.springmvcexample.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public boolean login(String id, String password){
        return id.equals("groom") && password.equals("groom");
    }
}
