package concurrency;

class Counter {
    private int counter = 0;

    void inc() {
        counter++;
    }

    void dec() {
        counter--;
    }

    int get() {
        return counter;
    }

    void reset() {
        counter = 0;
    }
}

class Worker implements Runnable {
    final Counter counter;
    final int limit;
    Worker(Counter counter, int limit) {
        this.counter = counter;
        this.limit = limit;
    }

    @Override
    public void run() {
        while(counter.get() < limit) {
            counter.inc();
        }
    }
}

public class ConcurrentCounter {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread thread1 = new Thread(new Worker(counter, 10));
        Thread thread2 = new Thread(new Worker(counter, 10));

        thread1.start();
        thread2.start();

        System.out.println(counter.get());
    }
}
