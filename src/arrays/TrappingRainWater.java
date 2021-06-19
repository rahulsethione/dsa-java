package arrays;

/**
 * @description https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] testcase = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(solution(testcase));
    }

    private static int solution(int[] heights) {
        int tallest = 0;
        int waters = 0;

        // Pass 1
        int[] ltrWaters = new int[heights.length];

        for(int i = 0; i < heights.length; i++) {
            tallest = Math.max(heights[i], tallest);

            ltrWaters[i] = tallest - heights[i];
        }

        // Pass 2
        tallest = 0;
        int[] rtlWaters = new int[heights.length];

        for(int j = heights.length - 1; j >= 0; j--) {
            tallest = Math.max(heights[j], tallest);

            rtlWaters[j] = tallest - heights[j];
        }

        // Pass 3
        for(int k = 0; k < heights.length; k++) {
            waters += Math.min(ltrWaters[k], rtlWaters[k]);
        }

        return waters;
    }
}
