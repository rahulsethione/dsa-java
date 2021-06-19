package arrays;

/**
 * @description https://leetcode.com/problems/container-with-most-water/submissions/
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] heights = new int[] {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(heights));
    }

    public static int maxArea(int[] heights) {
        int maxWater = 0;
        int i = 0, j = heights.length - 1;

        while( i !=j ) {
            int min = Math.min(heights[i], heights[j]);
            int water = (j - i) * min;

            maxWater = Math.max(water, maxWater);

            if(heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxWater;
    }
}
