package org.example.springmvcexample.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springmvcexample.dto.InfoDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/api")
public class InfoController {
    @GetMapping("/info")
    public InfoDto info() {
        return new InfoDto("1.0.0", "GoormBackEnd", LocalDateTime.now());
    }
}
