package arrays;

/**
 * @tags Goldman Sachs, Greedy Algorithm
 */
public class SmallestConsecutiveSubarrayTarget {
    public static void main(String[] args) {
        int[] test1 = {4, 1, 2, 3};
        int[] test2 = {1, 2, 3, 4};

        log(solution(test1, 6));
        log(solution(test2, 6));
    }

    private static void log(Object printable) { System.out.println(printable); }

    static int solution(int[] arr, int target) {
        int i = 0;
        int sum = arr[0];
        int minLength = Integer.MAX_VALUE;

        for(int j = 1; j < arr.length; j++) {
            sum += arr[j];

            while(sum >= target && j >= i) {
                minLength = Math.min(minLength, j - i + 1);
                sum -= arr[i];
                i++;
            }
        }

        return minLength == Integer.MAX_VALUE ? -1: minLength;
    }
}
