import java.util.concurrent.atomic.AtomicLong;

public class Counter {
    private volatile AtomicLong value = new AtomicLong(0);

    public void increase() {
        value.incrementAndGet();
    }

    public AtomicLong get() {
        return value;
    }

}
