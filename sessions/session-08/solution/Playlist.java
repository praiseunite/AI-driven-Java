import java.util.ArrayList;

class Song {
    private final String title;
    private final int seconds;
    Song(String title, int seconds) { this.title = title; this.seconds = seconds; }
    String getTitle() { return title; }
    int getSeconds() { return seconds; }
    @Override public String toString() {
        return String.format("%-18s %d:%02d", title, seconds / 60, seconds % 60);
    }
}

public class Playlist {
    private final ArrayList<Song> songs = new ArrayList<>();

    void add(Song s) { songs.add(s); }

    int totalSeconds() {
        int t = 0;
        for (Song s : songs) t += s.getSeconds();
        return t;
    }

    Song longest() {
        Song best = songs.get(0);
        for (Song s : songs) if (s.getSeconds() > best.getSeconds()) best = s;
        return best;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist();
        p.add(new Song("Intro", 95));
        p.add(new Song("Deep Focus", 372));
        p.add(new Song("Sprint", 188));

        for (Song s : p.songs) System.out.println(s);
        int total = p.totalSeconds();
        System.out.printf("Total  : %d:%02d%n", total / 60, total % 60);
        System.out.println("Longest: " + p.longest());
    }
}
