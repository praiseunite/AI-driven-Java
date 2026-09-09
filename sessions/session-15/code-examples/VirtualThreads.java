/**
 * JDK 21+ : virtual threads. Millions can run cheaply because they don't each
 * pin an OS thread. Here we spawn 10,000 and wait for them all.
 */
import java.util.concurrent.atomic.AtomicInteger;

public class VirtualThreads {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger done = new AtomicInteger();
        int n = 10_000;
        Thread[] workers = new Thread[n];

        for (int i = 0; i < n; i++) {
            workers[i] = Thread.ofVirtual().start(() -> {
                // pretend to do a little work
                int x = 0;
                for (int k = 0; k < 100; k++) x += k;
                done.incrementAndGet();
            });
        }
        for (Thread t : workers) t.join();

        System.out.println("virtual threads completed: " + done.get());
    }
}
