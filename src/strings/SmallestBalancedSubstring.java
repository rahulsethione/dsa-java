package strings;

/**
 * @note: A substring is said to be balanced if it contains lowercase and uppercase of same characters.
 * @example: String "azAZa" is balanced as it contains 'a' and 'A' as well as 'z' and 'Z'.
 * @problem: Given a string, find the minimum length of the substring which is balanced. If the string is not balanced return -1
 */
public class SmallestBalancedSubstring {
    public static void main(String[] args) {
        String testcase = "azABaabza";
        String smallestBalancedSubstring = "ABaab";
        int expectedOutput = smallestBalancedSubstring.length();
        int output = solution(testcase);

        assert output == expectedOutput : "Wrong output: " + output + ". Expected output: " + expectedOutput;
    }

    static int solution(String str) {
        char[] arr = str.toCharArray();
        int to = 0, from = arr.length - 1;
        boolean hasBalancedString = false;
        int result = arr.length;

        for(int i = to; i <= from; i++) {
            for(int j = i + 1; j <= from; j++) {
                if(balanced(arr, i, j)) {
                    hasBalancedString = true;
                    result = Math.min(result, j - i + 1);
                }
            }
        }

        return hasBalancedString ? result : -1;
    }

    static boolean balanced(char[] arr, int l, int r) {
        int[] map = new int[256];

        for(int i = l; i <= r; i++) {
            map[arr[i]]++;
        }

        boolean result = true;

        for(int i = l; i <= r; i++) {
            boolean charBalanced = map[arr[i] - 32] > 0 || map[arr[i] + 32] > 0;
            result = result && charBalanced;
            if(!result)
                break;
        }

        return result;
    }
}
