import java.util.concurrent.atomic.AtomicLong;

public class Counter {
    private volatile Long value = 0L;

    public void increase() {
        synchronized (Counter.class) {
            value++;
        }
    }

    public Long get() {
        return value;
    }

}
