package arrays;

/**
 *
 */
public class PivotInSortedRotatedArray {
    public static void main(String[] args) {
        // int[] arr = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        int[] arr = {8, 9, 1, 2, 3, 4, 5, 6, 7};
        // int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int num = 9;

        int result = pivotIndex(arr, num);

        System.out.println(result);
    }

    static int pivotIndex(int[] arr, int num) {
        return modifiedBinarySearch(arr, num, 0, arr.length - 1);
    }

    static int modifiedBinarySearch(int[] arr, int num, int i, int j) {
        if(i == j) {
            if(arr[i] == num) {
                return i;
            }

            return -1;
        }

        int mid = i + (j - i)/2;

        if(arr[mid] == num) {
            return mid;
        }

        if(arr[mid] < num && arr[i] > arr[mid]) {
            return modifiedBinarySearch(arr, num, i, mid - 1);
        } else {
            return modifiedBinarySearch(arr, num, mid + 1, j);
        }
    }
}
