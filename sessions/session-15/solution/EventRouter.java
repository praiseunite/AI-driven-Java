public class EventRouter {
    sealed interface Event permits Click, KeyPress, Scroll {}
    record Click(int x, int y) implements Event {}
    record KeyPress(char key) implements Event {}
    record Scroll(int amount) implements Event {}

    static String handle(Event e) {
        return switch (e) {
            case Click(int x, int y)          -> "click at (" + x + "," + y + ")";
            case KeyPress(char k)             -> "key '" + k + "'";
            case Scroll s when s.amount() > 0 -> "scroll down " + s.amount();
            case Scroll s                     -> "scroll up " + (-s.amount());
        };
    }

    public static void main(String[] args) {
        Event[] events = {
            new Click(10, 20), new KeyPress('A'),
            new Scroll(3), new Scroll(-2)
        };
        for (Event e : events) System.out.println(handle(e));
    }
}
