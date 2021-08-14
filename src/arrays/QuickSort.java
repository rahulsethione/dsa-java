package arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};

        quickSort(arr, 0, arr.length - 1);

        return;
    }

    static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pivot = partition(arr, low, high);

            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivotIndex = high;

        int i = low - 1;

        for(int j = low; j < high; j++) {
            if(arr[j] < arr[pivotIndex]) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);

        return i + 1;
    }

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
