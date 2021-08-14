package arrays;

public class CountPeaks {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};

        int result = peaks(arr);

        System.out.println(result);
        return;
    }

    static int peaks(int[] arr) {
        int i = 0;
        int peaks = 0;

        while(i < arr.length - 1) {
            while(i < arr.length - 1 && arr[i] > arr[i+1])
                i++;
            peaks++;

            // while (i < arr.length - 1 && arr[i] <= arr[i+1])
            i++;
        }

        return peaks;
    }
}
