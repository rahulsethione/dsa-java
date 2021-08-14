package arrays;

public class RemoveDuplicatesNoExtraSpace {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 4, 5, 6, 6};

        System.out.println(removeDuplicates(arr));
        return;
    }

    static int removeDuplicates(int[] arr) {
        int j = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] != arr[i + 1]) {
                arr[j++] = arr[i];
            }
        }

        arr[j++] = arr[arr.length - 1];

        return j;
    }
}
