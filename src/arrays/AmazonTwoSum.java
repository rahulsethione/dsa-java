package arrays;

import java.util.HashMap;
import java.util.Map;

public class AmazonTwoSum {
    public static void main(String[] args) {
        int[] nums = {3,2,4}; int target = 6;

        int[] result = solution(nums, target);

        return;
    }

    static int[] solution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            Integer j = map.get(target - nums[i]);

            if(j != null && i != j)
                return new int[] { Math.min(i, j), Math.max(i, j) };

            map.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}
