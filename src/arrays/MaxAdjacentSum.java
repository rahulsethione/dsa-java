package arrays;

public class MaxAdjacentSum {
    public static void main(String[] args) {
        int[] test1 = { 5, 10, 100, 100, 10, 5 };
        int[] test2 = { 10, 5, 20, 40, 25, 35, 15 };
        int[] test3 = { 10, 200 };

        assert solution(test1) == 115: "Test case 1 failed.";
        log("Max Sum = " + solution(test1));

        assert solution(test2) == 85: "Test case 2 failed.";
        log("Max Sum = " + solution(test2));

        assert solution(test3) == 200: "Test case 3 failed.";
        log("Max Sum = " + solution(test3));
    }

    private static void log(Object printable) { System.out.println(printable); }

    private static int solution(int[] arr) {
        if(arr.length == 0) {
            return 0;
        }
        if(arr.length == 1) {
            return arr[0];
        }
        if(arr.length < 3) {
            return Math.max(arr[0], arr[1]);
        }

        int sum = arr[0], altSum = arr[1];

        for(int i = 2; i < arr.length; i++) {
            int max = Math.max(sum, altSum);
            altSum = sum + arr[i];
            sum = max;
        }

        return Math.max(sum, altSum);
    }
}
