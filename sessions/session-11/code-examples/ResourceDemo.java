class Connection implements AutoCloseable {
    private final String name;
    Connection(String name) {
        this.name = name;
        System.out.println("opened " + name);
    }
    void use() { System.out.println("using " + name); }
    @Override public void close() { System.out.println("closed " + name); }
}

public class ResourceDemo {
    public static void main(String[] args) {
        // try-with-resources: close() is called automatically, even if an exception is thrown
        try (Connection c = new Connection("db")) {
            c.use();
            throw new RuntimeException("boom");
        } catch (RuntimeException e) {
            System.out.println("caught: " + e.getMessage());
        }
        System.out.println("done");
    }
}
