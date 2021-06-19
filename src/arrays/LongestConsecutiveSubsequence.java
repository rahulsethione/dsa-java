package arrays;

import java.util.Arrays;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42, 33, 33, 33, 1, 2, 3, 4, 5, 6};
        int result = longestConsecutiveSubsequence(arr);
        log(result);
    }

    private static void log(Object printable) { System.out.println(printable); }

    static int longestConsecutiveSubsequence(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        int length = 0, maxLength = 0;

        Arrays.sort(copy);

        for(int i = 1; i < copy.length; i++) {
            int diff = copy[i] - copy[i - 1];
            if(diff == 1) {
                length++;
                maxLength = Math.max(maxLength, length);
            } else if(diff == 0) {

            } else  {
                length = 0;
            }
        }
        return maxLength > 0 ? maxLength + 1: 0;
    }
}
