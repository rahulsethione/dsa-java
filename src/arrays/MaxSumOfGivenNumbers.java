package arrays;

/**
 * @note: Sliding window
 */
public class MaxSumOfGivenNumbers {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;
        int result = solution(arr, k);

        assert result == 39 : "Wrong answer: " + result;
        System.out.println("Right answer: " + result);
    }

    static int solution(int[] arr, int n) {
        int result = 0;
        int k = 0;

        for(int i = 0; i < arr.length; i++) {
            if(k < n) {
                result += arr[i];
                k++;
            } else {
                result = Math.max(result - arr[i - k] + arr[i], result);
            }
        }

        return result;
    }
}
