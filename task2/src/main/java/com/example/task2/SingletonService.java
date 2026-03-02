package com.example.task2;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class SingletonService {
    private volatile AtomicLong value = new AtomicLong(0);

    public Long increaseValue(Long delta) {
        return value.addAndGet(delta);
    }

    public AtomicLong getValue() {
        return value;
    }


}
