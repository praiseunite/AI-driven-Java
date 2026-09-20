public class GenericsDemo {

    static class Box<T> {
        private T value;
        void put(T value) { this.value = value; }
        T get() { return value; }
    }

    // generic method with a bounded type parameter
    static <T extends Comparable<T>> T maxOf(T a, T b) {
        return (a.compareTo(b) >= 0) ? a : b;
    }

    public static void main(String[] args) {
        Box<String> sb = new Box<>();
        sb.put("packed");
        System.out.println("box: " + sb.get());

        Box<Integer> ib = new Box<>();
        ib.put(42);
        System.out.println("box: " + ib.get());

        System.out.println("maxOf(3, 9)       : " + maxOf(3, 9));
        System.out.println("maxOf(\"apple\",\"pear\") : " + maxOf("apple", "pear"));
    }
}
