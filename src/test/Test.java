package test;

import java.util.*;

// SOLID - Note
// T1 running notify-wait
// T2 running notify-wait
// Aggregator service
// API First approach - Note
// ELK
// Node.js Express - Middleware
// Spring Boot - Interceptor
// Set-Cookie: Https=only;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4};

        List<List<Integer>> result = solve(arr);

        return;
    }

    // O(2 * n) = O(n)
    // O(n)
    static List<List<Integer>> solve(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0;  i < arr.length; i++ ) { // O(n)
            int count = Optional.ofNullable(map.get(arr[i])).orElse(0);
            map.put(arr[i], count + 1);
        }

        List<Integer> unique = new ArrayList<>();
        List<Integer> duplicates = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) { // O(n) - Worst
            if(entry.getValue() == 1) {
                unique.add(entry.getKey());
            } else {
                duplicates.add(entry.getKey());
            }
        }

        return Arrays.asList(unique, duplicates);
    }
}
