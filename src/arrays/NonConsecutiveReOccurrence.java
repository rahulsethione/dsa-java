package arrays;

public class NonConsecutiveReOccurrence {
    public static void main(String[] args) {
        int[] testcase1 = new int[] { 0, 1, 1, 4, 5, 2, 6, 1, 8 },
            testcase2 = new int[] { 0, 1, 1, 1, 5, 2, 6, 4, 8 };
        int n = 1;

        System.out.println(solution(testcase1, n));
        System.out.println(solution(testcase2, n));
    }

    private static int indexOf(int[] arr, int n) {
        int index = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == n) {
                index = i;
                break;
            }
        }

        return index;
    }

    private static int lastIndexOf(int[] arr, int n) {
        int index = -1;
        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] == n) {
                index = i;
                break;
            }
        }

        return index;
    }

    private static boolean solution(int[] arr, int n) {
        int firstIndex = indexOf(arr, n),
            lastIndex = lastIndexOf(arr, n);

        boolean result = true;

        for(int k = firstIndex; k <= lastIndex; k++) {
            if(arr[k] != n) {
                result = false;
                break;
            }
        }

        return result;
    }
}
