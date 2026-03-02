import java.util.concurrent.atomic.AtomicLong;

public class Counter {
//  private static long value = 0;
//  private static volatile long value = 0;
    private static final AtomicLong value = new AtomicLong(0);

//    public void increase() {
//        value++;
//    }

//    public synchronized void increase() {
//            value++;
//    }
//
//    public void increase() {
//        synchronized (Counter.class) {
//            value++;
//        }
//    }

    public void increase() {
        value.incrementAndGet();
    }

    public long get() {
        return value.get();
    }

}
