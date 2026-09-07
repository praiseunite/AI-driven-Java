import java.util.Objects;

class Money {
    private final long cents;
    Money(long cents) { this.cents = cents; }
    Money plus(Money other) { return new Money(cents + other.cents); }
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        return cents == ((Money) o).cents;
    }
    @Override public int hashCode() { return Objects.hash(cents); }
    @Override public String toString() { return String.format("$%d.%02d", cents / 100, cents % 100); }
}

public class MoneyDemo {
    public static void main(String[] args) {
        Money a = new Money(1250);
        Money b = new Money(1250);
        Money sum = a.plus(new Money(75));

        System.out.println("a           : " + a);
        System.out.println("a == b      : " + (a == b));
        System.out.println("a.equals(b) : " + a.equals(b));
        System.out.println("a + $0.75   : " + sum);
    }
}
