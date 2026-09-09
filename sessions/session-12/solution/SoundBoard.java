// "After" — the instanceof ladder replaced by polymorphism
interface Instrument {
    String play();
}

class Guitar implements Instrument {
    @Override public String play() { return "Guitar: strum strum"; }
}
class Drum implements Instrument {
    @Override public String play() { return "Drum: boom boom"; }
}
class Flute implements Instrument {
    @Override public String play() { return "Flute: tweet tweet"; }
}

public class SoundBoard {
    static void playAll(Instrument[] band) {
        for (Instrument i : band) {
            System.out.println(i.play());     // no instanceof, no if-ladder
        }
    }

    public static void main(String[] args) {
        Instrument[] band = { new Guitar(), new Drum(), new Flute(), new Guitar() };
        playAll(band);
    }
}
