package strings;

public class LongestPalindrome {
    public static void main(String[] args) {
        String result = longestPalindrome("chasecarracecars");

        assert result == "ecarrace": "Wrong answer: " + result;
        System.out.println("Right answer: " + result);

        String dpResult = dynamicProgramming("chasecarracecars");

        assert dpResult == "ecarrace": "Wrong answer: " + dpResult;
        System.out.println("Right answer: " + dpResult);

        String dpResult1 = dynamicProgramming("salalal");

        assert dpResult1 == "alala": "Wrong answer: " + dpResult1;
        System.out.println("Right answer: " + dpResult1);

        String dpResult2 = dynamicProgramming("BaaT");

        assert dpResult2 == "aa": "Wrong answer: " + dpResult2;
        System.out.println("Right answer: " + dpResult2);
    }

    // Brute Force O(n^3)
    static String longestPalindrome(String str) {
        char[] chars = str.toCharArray();
        String result = "";

        // O(n)
        for(int i = 0; i < chars.length; i++) {
            int tail = chars.length;

            // O(n)
            while(i < tail) {
                int j = -1;

                // O(n)
                for(int k = tail - 1; k >= 0; k--) {
                    if(chars[k] == chars[i]) {
                        j = k;
                        break;
                    }
                }

                int m = i, n = j;

                // O(n)
                while (m < n && chars[m] == chars[n]) {
                    m++;
                    n--;
                }

                if(m >= n) {
                    int length = j - i + 1;
                    if(length > result.length()) {
                        result = str.substring(i, j + 1);
                    }
                }

                tail = j; // Reset to next search from last found index

            }
        }

        return result;
    }

    static String dynamicProgramming(String str) {
        int start = 0, end = 0;
        int maxLength = 0;

        for(int i = 0; i < str.length(); i++) {
            int len1 = expansionLength(str, i, i);
            int len2 = expansionLength(str, i, i + 1);

            int len = Math.max(len1, len2);

            if(len > maxLength) {
                maxLength = len;

                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }

        return str.substring(start, end + 1);
    }

    private static int expansionLength(String str, int start, int end) {
        int i = start, j = end;

        while(i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)) {
            i--;
            j++;
        }

        return j - i - 1;
    }
}
