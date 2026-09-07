class Car {
    final String plate;
    Car(String plate) { this.plate = plate; }
}

public class ParkingLot {
    private final Car[] slots;

    ParkingLot(int size) { slots = new Car[size]; }

    boolean park(Car c) {
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] == null) {
                slots[i] = c;
                System.out.println(c.plate + " parked in slot " + i);
                return true;
            }
        }
        System.out.println(c.plate + " -> lot full");
        return false;
    }

    void leave(int slot) {
        if (slot >= 0 && slot < slots.length && slots[slot] != null) {
            System.out.println(slots[slot].plate + " leaves slot " + slot);
            slots[slot] = null;
        }
    }

    int freeCount() {
        int free = 0;
        for (Car c : slots) if (c == null) free++;
        return free;
    }

    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(3);
        lot.park(new Car("ABC-1"));
        lot.park(new Car("XYZ-9"));
        lot.leave(0);
        lot.park(new Car("JJJ-7"));
        lot.park(new Car("KKK-2"));
        lot.park(new Car("LLL-5"));
        System.out.println("Free slots: " + lot.freeCount());
    }
}
