package arrays;

public class LargestSumContagiousSubarray {
    public static void main(String[] args) {
        int[] arr1 = {-2, -3, 4, -1, -2, 1, 5, -3};
        int[] arr2 = {-4, 5, 2, -6, -2, 10, -8};
        int result1 = largestSumContagiousSurray(arr1);
        int result2 = largestSumContagiousSurray(arr2);
        log(result1);
        log(result2);
    }

    private static void log(Object printable) { System.out.println(printable); }

    static int largestSumContagiousSurray(int[] arr) {
        int largestSum = Integer.MIN_VALUE, currentSum = 0;

        for(int i = 0; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            largestSum = Math.max(currentSum, largestSum);
        }

        return largestSum;
    }
}
