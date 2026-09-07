class Lease implements AutoCloseable {
    private final int id;
    Lease(int id) { this.id = id; System.out.println("acquire lease " + id); }
    void work() { System.out.println("work with lease " + id); }
    @Override public void close() { System.out.println("release lease " + id); }
}

public class ResourcePool {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            try (Lease lease = new Lease(i)) {
                lease.work();
                if (i == 2) throw new IllegalStateException("problem on " + i);
            } catch (IllegalStateException e) {
                System.out.println("handled: " + e.getMessage());
            }
        }
        System.out.println("all leases released");
    }
}
