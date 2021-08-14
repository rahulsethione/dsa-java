package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @tags: Backtracking
 */
public class SubsetsOfArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> result = subsets(arr);
        return;
    }

    static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        subset(nums, 0, Collections.emptyList(), result);

        return result;
    }

    private static void subset(int[] nums, int index,
                        List<Integer> list, List<List<Integer>> result) {
        result.add(list);

        for(int i = index; i < nums.length; i++) {
            List<Integer> updatedList = copyAndAdd(list, nums[i]);
            subset(nums, i + 1, updatedList, result);
        }
    }

    private static List<Integer> copyAndAdd(List<Integer> list, int num) {
        List<Integer> copy = new ArrayList<>(list);

        copy.add(num);

        return copy;
    }
}
