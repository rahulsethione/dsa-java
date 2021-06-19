package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Knapsack {
    public static void main(String[] args) {
        // Test case
        int[] weights = new int[] {10, 20, 30};
        int[] values = new int[] {60, 100, 120};
        int capacity = 50;

        System.out.println("Brute force");
        Integer[] result = bruteForce(weights, values, capacity);
        System.out.println(Arrays.asList(result).stream().map(i -> i.toString()).collect(Collectors.joining(", ")));
        System.out.println("Also brute force");
        System.out.println(alsoBruteForce(weights, values, capacity, 0));
    }

    static Integer[] bruteForce(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[] arr = new int[n];
        List<Integer[]> permutations = new ArrayList<>();

        binaryNumbers(0, n, arr, permutations);

        int maxValue = 0;
        Integer[] result = new Integer[n];

        for(Integer[] permutation: permutations) {
            int w = 0, v = 0;
            for(int i = 0; i < permutation.length; i++) {
                w += permutation[i] * weights[i];
                v += permutation[i] * values[i];
            }

            if(w <= capacity && v > maxValue) {
                maxValue = v;
                result = permutation;
            }
        }

        return result;
    }

    static void binaryNumbers(int i, int n, int[] arr, List<Integer[]> result) {
        if (i == n) {
            result.add(Arrays.stream(arr).mapToObj(Integer::new).collect(Collectors.toList()).toArray(new Integer[n]));
            return;
        }
        for (int j = 0; j < 2; j++) {
            arr[i] = j;
            binaryNumbers(i + 1, n, Arrays.copyOf(arr, arr.length), result);
        }
    }

    static int alsoBruteForce(int[] weights, int[] values, int capacityRemaining, int currentIndex) {
        if(currentIndex == weights.length || capacityRemaining <= 0) {
            return 0;
        }

        if(weights[currentIndex] > capacityRemaining) {
            return alsoBruteForce(weights, values, capacityRemaining, currentIndex + 1);
        }

        int valueWith = values[currentIndex] + alsoBruteForce(weights, values, capacityRemaining - weights[currentIndex], currentIndex + 1);
        int valueWithout = alsoBruteForce(weights, values, capacityRemaining, currentIndex + 1);

        return Math.max(valueWith, valueWithout);
    }
}
