package org.example.springmvcexample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {
    public String testValue="success";
    @GetMapping("/test/auth/login")
    public String testAuth() {
        if(testValue.equals("success"))
            testValue="fail";
        else
            testValue="success";
        return "success";
    }
}
