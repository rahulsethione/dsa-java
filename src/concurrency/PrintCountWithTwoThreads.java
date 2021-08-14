package concurrency;

public class PrintCountWithTwoThreads {
    static class Runner implements Runnable {
        final int[] arr;

        public Runner(int[] arr) {
            this.arr = arr;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            try {
                for (int i = 0; i < arr.length; i++) {
                    Thread.sleep(i * 10);
                    System.out.println(arr[i]);
                }
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        Runner runner = new Runner(arr);
        Runner anotherRunner = new Runner(arr);
        Thread thread = new Thread(runner);
        Thread anotherThread = new Thread(anotherRunner);
        System.out.println(Thread.currentThread().getName());

        thread.start();
        anotherThread.start();
    }
}
