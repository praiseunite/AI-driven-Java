import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class TaskRunner {
    public static void main(String[] args) throws Exception {
        AtomicLong sum = new AtomicLong();
        int tasks = 2000;

        try (var pool = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 1; i <= tasks; i++) {
                final int n = i;
                pool.submit(() -> sum.addAndGet(n));
            }
        }   // close() waits for every task to finish

        long expected = (long) tasks * (tasks + 1) / 2;
        System.out.println("sum of 1.." + tasks + " via virtual threads = " + sum.get());
        System.out.println("matches formula? " + (sum.get() == expected));
    }
}
