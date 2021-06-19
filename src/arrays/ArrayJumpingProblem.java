package arrays;

/**
 * Starting from first element of an array of integer, find if the last element can be reach considering the value at any index of the array to be the maximum number of jump that can be made from that position towards the last element.
 */
public class ArrayJumpingProblem {

    public static void main(String[] args) {
        int[] arr1 = new int[] {5, 0, 0, 0, 0, 0, 0};
        int[] arr2 = new int[] {2, 2, 0, 1};

        log(reachable(arr1, 0));
        log(reachable(arr2, 0));
    }

    private static void log(Object printable) { System.out.println(printable); }

    public static boolean reachable(int[] arr, int index) {
        if(index >= arr.length - 1) {
            return true;
        }

        boolean result = false;

        for(int i = arr[index]; i > 0; i--) {
            result = result || reachable(arr, index + i);
            if(result) {
                break;
            }
        }

        return result;
    }
}
