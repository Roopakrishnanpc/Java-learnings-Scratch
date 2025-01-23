class Singleton {
    private static class SingletonInstanceClass {
        private static final Singleton Instance = new Singleton();
    }

    private Singleton() {
        // private constructor to prevent instantiation
    }

    public static Singleton getInstance() {
        return SingletonInstanceClass.Instance;
    }
}

public class Singlton {
    public static void main(String[] args) {
        // Test the Singleton pattern

        // Get two instances of the Singleton class
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        // Check if both instances are the same
        if (instance1 == instance2) {
            System.out.println("Singleton works! Both instances are the same.");
        } else {
            System.out.println("Singleton failed! Instances are different.");
        }
    }
}
