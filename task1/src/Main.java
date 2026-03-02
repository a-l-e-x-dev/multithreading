import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) counter.increase();
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) counter.increase();
        });
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) counter.increase();
        });
        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) counter.increase();
        });
        Thread thread5 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) counter.increase();
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();

        var expectedValue = 500_000;
        System.out.println("Ожидаемое значение: " + expectedValue);
        System.out.println("Фактическое значение: " + counter.get());
        System.out.println("Разница: " + (expectedValue - counter.get()));
    }
}
