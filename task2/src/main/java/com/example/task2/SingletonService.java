package com.example.task2;

import org.springframework.stereotype.Service;

@Service
public class SingletonService {
    //    private static final AtomicLong value = new AtomicLong(0);
    private static Long value = 0L;

//    public Long increaseValue(Long delta) {
//        return value.addAndGet(delta);
//    }
//
//    public Long getValue() {
//        return value.longValue();
//    }

    public Long increaseValue(Long delta) {
        synchronized (SingletonService.class) {
            return value += delta;
        }
    }

    public Long getValue() {
        return value;
    }

}
