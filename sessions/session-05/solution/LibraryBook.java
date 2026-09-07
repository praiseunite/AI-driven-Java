/**
 * Session 5 - Assignment 5 reference solution: Campus Library Book Tracker
 */
public class LibraryBook {
    private String title;
    private String author;
    private int copiesAvailable;
    private int copiesLent;

    public LibraryBook(String title, String author, int totalCopies) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = Math.max(totalCopies, 0);
        this.copiesLent = 0;
    }

    public void borrow() {
        if (copiesAvailable == 0) {
            System.out.printf("\"%s\": no copies available to borrow.%n", title);
        } else {
            copiesAvailable--;
            copiesLent++;
            System.out.printf("Borrowed \"%s\". Available: %d, Lent: %d%n", title, copiesAvailable, copiesLent);
        }
    }

    public void returnCopy() {
        if (copiesLent == 0) {
            System.out.printf("\"%s\": no copies are currently lent.%n", title);
        } else {
            copiesLent--;
            copiesAvailable++;
            System.out.printf("Returned \"%s\". Available: %d, Lent: %d%n", title, copiesAvailable, copiesLent);
        }
    }

    public int getCopiesAvailable() { return copiesAvailable; }

    public String status() {
        if (copiesAvailable == 0) return "ALL OUT";
        if (copiesLent == 0)      return "FULLY STOCKED";
        return "PARTIALLY LENT";
    }

    @Override
    public String toString() {
        return String.format("%s by %s [%s] (avail %d / lent %d)",
                title, author, status(), copiesAvailable, copiesLent);
    }

    public static void main(String[] args) {
        LibraryBook effJava = new LibraryBook("Effective Java", "Bloch", 2);

        effJava.borrow();
        effJava.borrow();
        effJava.borrow();       // rejected: none left
        effJava.returnCopy();
        effJava.returnCopy();
        effJava.returnCopy();   // rejected: none lent

        System.out.println(effJava);
    }
}
