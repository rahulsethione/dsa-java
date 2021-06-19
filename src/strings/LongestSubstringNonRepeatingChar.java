package strings;

import java.util.Arrays;

public class LongestSubstringNonRepeatingChar {
    public static void main(String[] args) {
        String testcase = "GEEKSFORGEEKS";

        log(solution(testcase));
        log(nSquareSolution(testcase));
        log(linearSolution(testcase));
        log(linear(testcase));
    }

    private static void log(Object printable) { System.out.println(printable); }

    private static String solution(String str) {
        String result = "";

        for(String substring: substrings(str)) {
            if(substring != null && hasNonRepeatingChar(substring) && result.length() < substring.length()) {
                result = substring;
            }
        }

        return result;
    }

    private static String[] substrings(String str) {
        String[] substrings = new String[str.length() * str.length() + str.length()];

        for (int i = 0; i < str.length(); i++) {
            for(int j = i; j <= str.length(); j++) {
                substrings[(i * str.length()) + j] = str.substring(i, j);
            }
        }

        return substrings;
    }

    private static boolean hasNonRepeatingChar(String substring) {
        boolean result = true;
        for(int k = 0; k < substring.length(); k++) {
            if(substring.indexOf(substring.charAt(k)) != substring.lastIndexOf(substring.charAt(k))) {
                result = false;
                break;
            }
        }

        return result;
    }

    private static String nSquareSolution(String str) {
        String result = "";

        for(int i = 0; i < str.length(); i++) {
            boolean[] visited = new boolean[256];

            for(int j = i; j < str.length(); j++) {
                if(visited[str.charAt(j)]) {
                    break;
                } else {
                    String substring = str.substring(i, j + 1);
                    if(substring.length() > result.length()) {
                        result = substring;
                    }
                    visited[str.charAt(j)] = true;
                }
            }
        }

        return result;
    }

    private static String linearSolution(String str) {
        final int NO_DISTINCT_CHAR = 256;
        final int[] charLastPosMap = new int[NO_DISTINCT_CHAR];
        int start = 0, end = 0, maxLength = 0;

        int i = 0, length = 0;

        Arrays.fill(charLastPosMap, -1);

        for(int j = 0; j < str.length(); j++) {
            if(charLastPosMap[str.charAt(j)] > -1) {
                if(length > maxLength) {
                    start = i;
                    end = j;
                    maxLength = length;
                }
            }
            i = Math.max(i, charLastPosMap[str.charAt(j)] + 1);
            charLastPosMap[str.charAt(j)] = j;
            length = j - i + 1;
        }

        return str.substring(start, end);
    }

    static String linear(String str) {
        int[] lastCharPosMap = new int[256];

        Arrays.fill(lastCharPosMap, -1);

        int i = 0, start = 0, end = 0, maxLength = 0;

        for(int j = 0; j < str.length() - 1; j++) {
            char character = str.charAt(j);

            if(lastCharPosMap[character] > -1) {
                int length = j - i;
                if(length > maxLength) {
                    maxLength = length;
                    start = i;
                    end = j;
                }
                i = i + 1;
                j = i;
            }

            lastCharPosMap[character] = j;
        }

        return str.substring(start, end + 1);
    }

}
