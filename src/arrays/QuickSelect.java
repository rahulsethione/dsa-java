package arrays;

/**
 * Find kth smallest number in array
 */
public class QuickSelect {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};

        int k = 3;

        int result = quickSelect(arr, k, 0, arr.length - 1);

        return;
    }

    static int quickSelect(int[] arr, int k, int low, int high) {
        int pivot = partition(arr, low, high);

        if(pivot == k - 1)
            return arr[pivot];

        if(pivot > k - 1)
            return quickSelect(arr, k, low, pivot - 1);
        else
            return quickSelect(arr, k, pivot + 1, high);
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = high;

        int i = low - 1;

        for(int j = low; j < high; j++) {
            if(arr[j] < arr[pivot]) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, pivot);
        return i + 1;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
