package arrays;

import java.util.Arrays;

public class MinTrainPlatform {
    public static void main(String[] args) {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };

        int result = minPlatform(arr, dep);

        System.out.println(result);
    }

    static int minPlatform(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int result = 1, count = 1;
        int i = 1, j = 0;

        while (i < arr.length && j < arr.length) {
            if(arr[i] <= dep[j]) {
                count++;
                i++;
            } else if(arr[i] > dep[j]) {
                count--;
                j++;
            }

            result = Math.max(count, result);
        }

        return count;
    }
}
