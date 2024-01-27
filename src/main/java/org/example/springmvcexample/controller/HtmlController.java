package org.example.springmvcexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    @GetMapping("/")
    public String indexRoot() {
        return "index";
    }
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/myself")
    public String myself(Model model) {
        model.addAttribute("name", "minsu");
        return "myself";
    }
}
