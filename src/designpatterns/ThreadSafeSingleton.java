package designpatterns;

public class ThreadSafeSingleton {

    // Volatile instance object will not be cached and multiple threads will not create local copies
    // Hence every time a thread tries to read the value on instance, it will be served most recently written value by any thread
    private static volatile ThreadSafeSingleton instance = null;

    private final String[] vars;

    private ThreadSafeSingleton(String ...args) {
        this.vars = args;
    }

    public String[] getVars() {
        return vars;
    }

    public static ThreadSafeSingleton getInstance(String ...args) {
        if(instance != null) {
            return instance;
        }

        // Only the lazy creation of the singleton instance needs to be synchronized
        // Because synchronized block will only be accessible by one thread at a time while blocking other threads
        synchronized (ThreadSafeSingleton.class) {
            // Double checking
            if(instance == null) {
                instance = new ThreadSafeSingleton(args);
            }

            return instance;
        }
    }

    /**
     * Eager initialization
     * Static block initialization
     * Lazy Initialization
     * Thread Safe Singleton
     * Bill Pugh Singleton Implementation
     * Using Reflection to destroy Singleton Pattern
     * Enum Singleton
     * Serialization and Singleton
     */
}
