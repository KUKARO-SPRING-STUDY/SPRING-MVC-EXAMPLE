package org.example.springmvcexample.controller;

import org.example.springmvcexample.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/err")
public class ErrorController {
    @GetMapping("/not-found")
    public String notFound() {
        throw new NotFoundException("The requested resource was not found");
    }
}
