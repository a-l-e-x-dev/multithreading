import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                for (int n = 0; n < 100_000; n++) counter.increase();
            });
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) { //
                executor.shutdownNow(); //
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        long expectedValue = 500_000L;
        log.info("Ожидаемое значение: {}", expectedValue);
        log.info("Фактическое значение: {}", counter.get());
        log.info("Разница: {}", expectedValue - counter.get().intValue());
    }

}
