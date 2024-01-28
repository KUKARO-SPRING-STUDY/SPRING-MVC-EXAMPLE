package org.example.springmvcexample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HtmlController {

    @GetMapping("/")
    public String indexRoot() {
        return "index";
    }
    @GetMapping("/index")
    @PreAuthorize("hasAnyRole('USER')")
    public String index() {
        log.info("ENTER INDEX");
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
