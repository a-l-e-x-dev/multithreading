package com.example.task2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final SingletonService service;

    @PostMapping("/increase")
    public Long increaseValue(@RequestParam(defaultValue = "1") Long delta) {
        return service.increaseValue(delta);
    }

    @GetMapping("/get")
    public AtomicLong getValue() {
        return service.getValue();
    }
}
