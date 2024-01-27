package org.example.springmvcexample.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springmvcexample.dto.ArithmeticDto;
import org.example.springmvcexample.request.ArithmeticRequest;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class CalculateController {
    @GetMapping("/add/{first}/to/{second}")
    public ArithmeticDto add(@PathVariable double first, @PathVariable double second) {
        return new ArithmeticDto(first, second, first + " + " + second + " = " + (first + second));
    }

    @GetMapping("/sub")
    public ArithmeticDto sub(@RequestParam double first, @RequestParam double second) {
        return new ArithmeticDto(first, second, first + " - " + second + " = " + (first - second));
    }

    @PostMapping("/mul")
    public ArithmeticDto mul(@RequestBody ArithmeticRequest request) {
        double first = request.getFirst();
        double second = request.getSecond();
        return new ArithmeticDto(first, second, first + " * " + second + " = " + (first * second));
    }
}
