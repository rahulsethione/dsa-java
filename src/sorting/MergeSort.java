package sorting;

import java.util.Arrays;

/**
 * Dynamic Programming: Merge Sort
 */
public class MergeSort {
    Integer[] sort(Integer[] arr) {
        Integer[] clone = arr.clone();

        applySort(clone, 0, clone.length - 1);

        return clone;
    }

    private void applySort(Integer[] arr, int start, int end) {
        if(start < end) {
            int partition = (start + (end - 1))/2;

            applySort(arr, start, partition);
            applySort(arr, partition + 1, end);

            merge(arr, start, end, partition);
        }
    }

    private void merge(Integer[] arr, int start, int end, int partition) {
        int leftLen = partition - start + 1,
            rightLen = end - partition;

        Integer[] left = new Integer[leftLen],
            right = new Integer[rightLen];

        for(int i = 0; i < leftLen; i++) {
            left[i] = arr[start + i];
        }

        for(int j = 0; j < rightLen; j++) {
            right[j] = arr[partition + 1 + j];
        }

        int i = 0, j = 0, k = start;

        while (i < leftLen && j < rightLen) {
            if(left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }

            k++;
        }

        while (i < leftLen) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < rightLen) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

}
