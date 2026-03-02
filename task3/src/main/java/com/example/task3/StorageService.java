package com.example.task3;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StorageService {
    private final StorageRepository storage;

    @Transactional
    public void increase(Long delta) {
        storage.increaseByDelta(1L, delta);
    }

    public Long get(Long id) {
        return storage.findById(id).get().getCounter();
    }
}
