class PasswordVault {
    private String password;              // private: no outside access

    public PasswordVault(String initial) {
        this.password = initial;
    }

    private boolean isStrong(String p) {  // private helper
        return p.length() >= 8 && !p.equalsIgnoreCase("password");
    }

    public boolean changePassword(String current, String next) {
        if (!password.equals(current)) {
            System.out.println("Current password wrong.");
            return false;
        }
        if (!isStrong(next)) {
            System.out.println("New password too weak.");
            return false;
        }
        password = next;
        System.out.println("Password changed.");
        return true;
    }

    public boolean verify(String attempt) {
        return password.equals(attempt);
    }
}

public class PasswordVaultDemo {
    public static void main(String[] args) {
        PasswordVault v = new PasswordVault("start123");

        v.changePassword("wrong", "muchbetter1");   // rejected: current wrong
        v.changePassword("start123", "short");        // rejected: weak
        v.changePassword("start123", "muchbetter1");  // accepted

        System.out.println("verify('muchbetter1') -> " + v.verify("muchbetter1"));
        System.out.println("verify('start123')    -> " + v.verify("start123"));
        // v.password;        // won't compile: password has private access
        // v.isStrong("abc"); // won't compile: isStrong has private access
    }
}
