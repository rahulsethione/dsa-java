package arrays;

/**
 * Leatcode: https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 */
public class LongestRepeatedSubarray {

    public static void main(String[] args) {
        testcaseOne();
        testcaseTwo();
    }

    static void testcaseOne() {
        int[] nums1 = {1,2,3,2,1}, nums2 = {3,2,1,4,7};
        int result = findLength(nums1, nums2);

        assert result == 3: "Wrong answer: " + result;
        System.out.println("Right answer: " + result);
    }

    static void testcaseTwo() {
        int[] nums1 = {0,0,0,0,0,0,1,0,0,0}, nums2 = {0,0,0,0,0,0,0,1,0,0};
        int result = findLength(nums1, nums2);

        assert result == 9: "Wrong answer: " + result;
        System.out.println("Right answer: " + result);
    }

    static int findLength(int[] nums1, int[] nums2) {
        int maxLength = 0;
        for(int i = 0; i < nums2.length; i++) {

            int j = nextIndexOf(nums2, nums1[i], -1);
            while(j > -1) {
                int length = 0;
                int k = i, p = j;

                while(k < nums1.length && p < nums2.length && nums1[k] == nums2[p]) {
                    length++;
                    maxLength = Math.max(length, maxLength);
                    k++;
                    p++;
                }

                j = nextIndexOf(nums2, nums1[i], j);
            }
        }

        return maxLength;
    }

    static int nextIndexOf(int[] arr, int n, int from) {
        // if(from == arr.length) return -1;
        for(int i = from + 1; i < arr.length; i++) {
            if(arr[i] == n) {
                return i;
            }
        }

        return -1;
    }
}
