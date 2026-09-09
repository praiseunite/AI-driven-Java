# Session 12: "Try It Yourself" Consolidation Challenges 🛠️

> **Module:** JAVA-I-TL12 | **Coverage:** Sessions 9–11 Review
> Reference solutions: [solution/solution.html](solution/solution.html)

Each challenge combines inheritance, an interface, and exceptions.

---

## 🟡 Challenge 12.1: Payment System (abstract + interface + exception)

```java
class PaymentException extends Exception {
    PaymentException(String msg) { super(msg); }
}

interface Refundable {
    void refund(double amount) throws PaymentException;
}

abstract class Payment {
    protected double amount;
    protected boolean settled = false;
    Payment(double amount) { this.amount = amount; }

    abstract double fee();

    final void settle() throws PaymentException {
        if (amount <= 0) throw new PaymentException("amount must be positive");
        settled = true;
        System.out.printf("%s settled $%.2f (fee $%.2f)%n",
                getClass().getSimpleName(), amount, fee());
    }
}

class CardPayment extends Payment implements Refundable {
    CardPayment(double amount) { super(amount); }
    @Override double fee() { return amount * 0.029 + 0.30; }
    @Override public void refund(double refundAmount) throws PaymentException {
        if (!settled) throw new PaymentException("cannot refund an unsettled payment");
        if (refundAmount > amount) throw new PaymentException("refund exceeds original");
        System.out.printf("Card refunded $%.2f%n", refundAmount);
    }
}

class CashPayment extends Payment {
    CashPayment(double amount) { super(amount); }
    @Override double fee() { return 0; }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Payment[] payments = { new CardPayment(100), new CashPayment(50), new CardPayment(-5) };
        for (Payment p : payments) {
            try {
                p.settle();
                if (p instanceof Refundable r) r.refund(25);
            } catch (PaymentException e) {
                System.out.println("FAILED: " + e.getMessage());
            }
        }
    }
}
```
**Expected output:**
```
CardPayment settled $100.00 (fee $3.20)
Card refunded $25.00
CashPayment settled $50.00 (fee $0.00)
FAILED: amount must be positive
```

---

## 🟡 Challenge 12.2: Refactor an `instanceof` ladder to polymorphism

First write the ugly `playAll(Object[])` with an `if (x instanceof Guitar) ... else if ...`
ladder, then convert to this. A 4th instrument must need **no** change to `playAll`.

```java
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
```
**Expected output:**
```
Guitar: strum strum
Drum: boom boom
Flute: tweet tweet
Guitar: strum strum
```

---

## 🔴 Challenge 12.3: Zoo Feeding (abstract animal + Feedable + FeedingException)

```java
class FeedingException extends Exception {
    FeedingException(String msg) { super(msg); }
}

interface Feedable {
    void feed(int grams) throws FeedingException;
}

abstract class Animal implements Feedable {
    protected final String name;
    protected int fedGrams = 0;
    Animal(String name) { this.name = name; }
    abstract int dailyNeed();
    @Override public void feed(int grams) throws FeedingException {
        if (grams <= 0) throw new FeedingException(name + ": portion must be positive");
        fedGrams += grams;
        System.out.printf("%-8s fed %d g (%d/%d)%n", name, grams, fedGrams, dailyNeed());
    }
    boolean isHungry() { return fedGrams < dailyNeed(); }
}

class Rabbit extends Animal {
    Rabbit(String name) { super(name); }
    @Override int dailyNeed() { return 150; }
}
class Lion extends Animal {
    Lion(String name) { super(name); }
    @Override int dailyNeed() { return 6000; }
}

public class Zoo {
    public static void main(String[] args) {
        Animal[] animals = { new Rabbit("Thumper"), new Lion("Leo") };
        int[][] portions = { {100, 60}, {4000, -1, 2500} };

        for (int a = 0; a < animals.length; a++) {
            for (int g : portions[a]) {
                try {
                    animals[a].feed(g);
                } catch (FeedingException e) {
                    System.out.println("  skipped: " + e.getMessage());
                }
            }
        }
        for (Animal an : animals) {
            System.out.println(an.name + " still hungry? " + an.isHungry());
        }
    }
}
```
**Expected output:**
```
Thumper  fed 100 g (100/150)
Thumper  fed 60 g (160/150)
Leo      fed 4000 g (4000/6000)
  skipped: Leo: portion must be positive
Leo      fed 2500 g (6500/6000)
Thumper still hungry? false
Leo still hungry? false
```
