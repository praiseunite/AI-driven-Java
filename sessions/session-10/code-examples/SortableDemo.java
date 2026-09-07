import java.util.Arrays;

class Book implements Comparable<Book> {
    final String title;
    final int pages;
    Book(String title, int pages) { this.title = title; this.pages = pages; }
    @Override public int compareTo(Book other) { return Integer.compare(this.pages, other.pages); }
    @Override public String toString() { return title + " (" + pages + "p)"; }
}

public class SortableDemo {
    public static void main(String[] args) {
        Book[] shelf = {
            new Book("Short Story", 40),
            new Book("Epic", 900),
            new Book("Novella", 150)
        };
        Arrays.sort(shelf);              // uses compareTo -> ascending by pages
        System.out.println(Arrays.toString(shelf));
    }
}
