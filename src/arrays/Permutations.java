package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    public static void main(String[] args) {
        Integer[] arr = new Integer[] { 1, 2, 3, 4 };

        solution(new ArrayList<>(), Arrays.asList(arr));

        List<List<Integer>> result = new ArrayList<>();

        generatePermutations(Collections.emptyList(), Arrays.asList(arr), result);

        for(List<Integer> permutation: result) {
            System.out.println(permutation.stream().map(i -> i.toString()).collect(Collectors.joining(", ")));
        }
    }

    private static void solution(List<Integer> permutation, List<Integer> remaining) {
        for(int i = 0; i < remaining.size(); i++) {
            List<Integer> newRem = new ArrayList<>(remaining);
            List<Integer> newPerm = new ArrayList<>(permutation);

            newPerm.add(newRem.remove(i));
            solution(newPerm, newRem);
        }

        if(remaining.size() == 0) {
            System.out.println(permutation.stream().map(i -> i.toString()).collect(Collectors.joining(", ")));
        }
    }

    private static void generatePermutations(List<Integer> permutations, List<Integer> remaining, List<List<Integer>> result) {
        for(int i = 0; i < remaining.size(); i++) {

            List<Integer> newPermutations = new ArrayList<>(permutations);
            List<Integer> newRemaining = new ArrayList<>(remaining);

            newPermutations.add(newRemaining.remove(i));
            generatePermutations(newPermutations, newRemaining, result);
        }

        if(remaining.isEmpty()) {
            result.add(permutations);
        }
    }
}
