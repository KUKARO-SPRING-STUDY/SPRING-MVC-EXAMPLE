package org.example.springmvcexample.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springmvcexample.dto.UserDto;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    @Secured("USER")
    public String index(@AuthenticationPrincipal UserDto userDto) {
        log.info("ENTER INDEX : {}", userDto);
        return "index";
    }

    @GetMapping("/login")
    public String login(@AuthenticationPrincipal UserDto userDto) {
        System.out.println(userDto);
        return "login";
    }

    @GetMapping("/myself")
    public String myself(Model model) {
        model.addAttribute("name", "minsu");
        return "myself";
    }
}
