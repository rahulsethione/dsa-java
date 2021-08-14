package arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int num = 5;

        int result = search(arr, num);

        System.out.println(result);
    }

    static int search(int[] arr, int num) {
        return searchThrough(arr, num, 0, arr.length - 1);
    }

    static int searchThrough(int[] arr, int num, int left, int right) {
        if(left == right) {
            if(arr[left] == num) {
                return left;
            }

            return -1;
        }

        int mid = left + (right - left) / 2;

        if(arr[mid] == num) {
            return mid;
        }

        if(arr[mid] > num) {
            return searchThrough(arr, num, left, mid - 1);
        } else {
            return searchThrough(arr, num, mid + 1, right);
        }
    }
}
