import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
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

        var expectedValue = 500_000;
        System.out.println("Ожидаемое значение: " + expectedValue);
        System.out.println("Фактическое значение: " + counter.get());
        System.out.println("Разница: " + (expectedValue - counter.get().intValue()));
    }

}
