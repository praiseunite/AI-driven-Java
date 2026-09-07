public class NestedDemo {

    // 1. static nested class — no link to an outer instance
    static class Point {
        final int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
        @Override public String toString() { return "(" + x + "," + y + ")"; }
    }

    private String label = "outer";

    // 2. inner (non-static) class — tied to a NestedDemo instance, can see its fields
    class Tagger {
        String tag(String s) { return "[" + label + "] " + s; }
    }

    interface Greeter { String greet(String name); }

    public static void main(String[] args) {
        Point p = new Point(3, 4);
        System.out.println("static nested: " + p);

        NestedDemo demo = new NestedDemo();
        NestedDemo.Tagger t = demo.new Tagger();     // inner class needs an outer instance
        System.out.println("inner:        " + t.tag("hello"));

        // 3. anonymous class implementing an interface inline
        Greeter g = new Greeter() {
            @Override public String greet(String name) { return "Hi, " + name + "!"; }
        };
        System.out.println("anonymous:    " + g.greet("Ada"));

        // 4. same thing as a lambda (interface has one abstract method)
        Greeter g2 = name -> "Hey, " + name + ".";
        System.out.println("lambda:       " + g2.greet("Bode"));
    }
}
