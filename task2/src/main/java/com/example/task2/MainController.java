package com.example.task2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final SingletonService service;

    @PostMapping("/increase")
    public Long increaseValue(@RequestParam(defaultValue = "1") Long delta) {
        service.increaseValue(delta);
        return service.getValue();
    }

    @GetMapping("/get")
    public Long getValue() {
        return service.getValue();
    }
}
