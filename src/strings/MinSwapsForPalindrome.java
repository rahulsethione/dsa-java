package strings;

public class MinSwapsForPalindrome {
    public static void main(String[] args) {
        String s = "caab";

        // Function calling
        boolean ans1 = canBePalindrome(s);
        int swaps = countSwap(s);
        System.out.println(ans1);
        System.out.println(swaps);
    }

    static boolean canBePalindrome(String str) {
        int[] map = new int[256];
        char[] arr = str.toCharArray();

        for(char character: arr) {
            map[character]++;
        }

        boolean hasCenter = false;

        for(int i = 0; i < 256; i++) {
            if(map[i] % 2 != 0) {
                if(!hasCenter) {
                    hasCenter = true;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    static int countSwap(String str) {
        int n = str.length();
        char s[] = str.toCharArray();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int left = i;
            int right = n - left - 1;

            while (left < n) {
                if (s[left] == s[right]) {
                    break;
                }
                else {
                    right--;
                }
            }

            if (left == right) {
                break;
            } else if (s[left] != s[n - left - 1]) {
                char temp = s[right];
                s[right] = s[n - left - 1];
                s[n - left - 1] = temp;
                count++;
            }
        }

        for (int i = n-1; i >= 0; i--) {
            int right = i;
            int left = n - right - 1;

            while (right >= 0) {
                if (s[left] == s[right]) {
                    break;
                }
                else {
                    left++;
                }
            }

            if (left == right) {
                break;
            } else if (s[right] != s[n - right - 1]) {
                char temp = s[left];
                s[left] = s[n - right - 1];
                s[n - right - 1] = temp;
                count++;
            }
        }

        return count;
    }
}
