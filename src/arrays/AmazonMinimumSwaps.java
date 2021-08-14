package arrays;

public class AmazonMinimumSwaps {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2}; // 1 {1,5,4,2} => 2 {1,4,5,2} => 3 {1,2,5,4} => 4 {1,2,4,5}
        int[] test = {1, 2, 7, 6, 8, 9, 12, 10}; // 1 {1,2,6,7,8,9,12,10} => 2 {1,2,6,7,8,9,10,12}
        int[] qa = {1, 9, 3, 4, 5, 2}; // 1 (9,2) {1,2,3,4,5,9}

        log(swapsCount(arr));
        log(swapsCount(test));
        log(swapsCount(qa));
    }

    private static void log(Object printable) { System.out.println(printable); }

    // Brute force O(n)
    static int swapsCount(int[] arr) {
        int count = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    swap(arr, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
