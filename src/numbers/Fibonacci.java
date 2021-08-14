package numbers;

public class Fibonacci {
    public static void main(String[] args) {
        int num = 10;

        log("Recursion:");
        fibonacciSeriesRecursion(num);
        log("Loop:");
        fibonacciSeriesLoop(num);
    }

    private static void log(Object printable) { System.out.println(printable); }

    static void fibonacciSeriesLoop(int n) {
        if(n == 0) return;

        if(n == 1) {
            log(0);
            return;
        }

        int x = 0, y = 1;

        log(x); log(y);

        for(int i = 2; i < n; i++) {
            int z = x + y;

            log(z);

            x = y;
            y = z;
        }
    }

    static void fibonacciSeriesRecursion(int n) {
        for(int i = 0; i < n; i++) {
            log(fibonacciNumber(i));
        }
    }

    static int fibonacciNumber(int n) {
        if(n == 0) {
            return 0;
        }

        if (n <= 2) {
            return 1;
        }

        return fibonacciNumber(n - 1) + fibonacciNumber(n - 2);
    }
}
