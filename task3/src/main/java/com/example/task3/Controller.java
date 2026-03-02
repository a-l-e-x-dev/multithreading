package com.example.task3;

import jakarta.persistence.OptimisticLockException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final StorageService service;

    @PostMapping("/increase")
    public void increase(@RequestParam(defaultValue = "1") Long delta) {
        service.increase(delta);
    }

    @GetMapping("/get")
    public Long get() {
        return service.get(1L);
    }
}
