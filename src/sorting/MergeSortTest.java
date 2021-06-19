package sorting;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class MergeSortTest {
    private static void log(Object printable) { System.out.println(printable); }
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        Integer[] arr = { 38, 27, 43, 3, 9, 82, 10 };

        Integer[] sortedArr = mergeSort.sort(arr);

        // Convert and parse String[] to int[]
        int[] test = Arrays.stream("3 1 3 2 3 2".split(" ")).mapToInt(Integer::parseInt).toArray();

        for(Integer i: sortedArr) { log(i); }
    }
}
