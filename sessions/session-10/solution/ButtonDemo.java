interface ClickHandler {
    void onClick(String button);
}

class Button {
    private final String name;
    private ClickHandler handler;
    Button(String name) { this.name = name; }
    void setHandler(ClickHandler h) { this.handler = h; }
    void press() { if (handler != null) handler.onClick(name); }
}

public class ButtonDemo {
    public static void main(String[] args) {
        Button save = new Button("Save");
        Button quit = new Button("Quit");

        // anonymous class
        save.setHandler(new ClickHandler() {
            @Override public void onClick(String button) {
                System.out.println("Saving... (" + button + " pressed)");
            }
        });

        // lambda (ClickHandler is a functional interface)
        quit.setHandler(b -> System.out.println("Bye! (" + b + " pressed)"));

        save.press();
        quit.press();
    }
}
