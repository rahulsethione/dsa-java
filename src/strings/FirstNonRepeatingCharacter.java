package strings;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String str = "geeksforgeeks";

        log(firstNonRepeatingChar(str));
        log(linearTimeComplexity(str));
        log(betterLinearTimeComplexity(str));
    }

    private static void log(Object printable) { System.out.println(printable); }

    // O(n^2)
    private static char firstNonRepeatingChar(String str) {
        // O(n)
        for(int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);

            int j = str.lastIndexOf(character); // O(n)

            if(i == j) {
                return character;
            }
        }

        return '0';
    }

    // O(n) { O(2 * n) }
    private static char linearTimeComplexity(String str) {
        int[] countMap = new int[256]; // Constant space complexity

        // O(n)
        for(int i = 0; i < str.length(); i++) {
            countMap[str.charAt(i)] += 1;
        }

        // O(n)
        for(int i = 0; i < str.length(); i++) {
            if (countMap[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }

        return '0';
    }

    // O(n) + Constant(512)
    private static int betterLinearTimeComplexity(String str) {
        int[] indexMap = new int[256]; // Constant space complexity

        // Constant time complexity
        for(int i = 0; i < 256; i++) {
            indexMap[i] = -1;
        }

        // O(n)
        for(int i = 0; i < str.length(); i++) {
            char iChar = str.charAt(i);
            if(indexMap[iChar] == -1) {
                indexMap[iChar] = i;
            } else {
                indexMap[iChar] = -2;
            }
        }

        int result = Integer.MAX_VALUE;

        // Constant time complexity
        for(int i = 0; i < 256; i++) {
            if(indexMap[i] >= 0) {
                result = Math.min(indexMap[i], result);
            }
        }

        if(result == Integer.MAX_VALUE) {
            return -1;
        }

        return result;
    }
}
