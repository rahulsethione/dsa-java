package arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MoveAllZerosToRight {
    private static void log(Object printable) { System.out.println(printable); }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 0, 0, 1, 0, 6, 0, 0, 9, 5};

        solution(arr);

        log(
            Arrays.stream(arr).map(Integer::new).mapToObj(Integer::toString).collect(Collectors.joining(", "))
        );
    }

    static void solution(int[] arr) {
        int i = 0, j = 0;

        while(i < arr.length) {
            if(arr[i] == 0 && arr[j] != 0) {
                j = i;
            } else if(arr[i] != 0 && arr[j] == 0) {
                swap(arr, i, j);
                j++;
            }

            i++;
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
