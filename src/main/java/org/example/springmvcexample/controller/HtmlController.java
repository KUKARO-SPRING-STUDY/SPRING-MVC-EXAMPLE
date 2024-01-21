package org.example.springmvcexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/myself")
    public String myself(Model model) {
        model.addAttribute("name", "minsu");
        return "myself";
    }
}
