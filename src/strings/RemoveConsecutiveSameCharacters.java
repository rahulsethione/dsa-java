package strings;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Stack;

public class RemoveConsecutiveSameCharacters {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        int k = 2;

        String str1 = "qddxxxd";
        int k1 = 3;

        String result = withTwoPointers(str, k);
        String result1 = withTwoPointers(str1, k1);

        String altResult = withStack(str, k);
        String altResult1 = withStack(str1, k1);

        log(result);
        log(result1);

        log(altResult);
        log(altResult1);
    }

    private static void log(Object printable) { System.out.println(printable); }

    static String withTwoPointers(String str, int k) {
        int i = 0, j = 0;

        while(i < str.length() - 1) {



            if(str.charAt(i) == str.charAt(j)) {
                i++;
            } else {
                j = i;
            }

            if(str.charAt(i) == str.charAt(j) && (i - j + 1) == k) {
                str = str.substring(0, j) + str.substring(i + 1);
                i = j = 0;
            }
        }

        return str;
    }

    static String withStack(String str, int k) {
        Stack<Map.Entry<Character, Integer>> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);
            int charCount = 1;

            if(!stack.isEmpty()) {
                Map.Entry<Character, Integer> top = stack.peek();

                if(top.getKey().equals(character)) {
                    charCount = top.getValue() + 1;
                }
            }

            stack.push(new AbstractMap.SimpleImmutableEntry<>(character, charCount));

            if(stack.peek().getValue().equals(k)) {
                for(int j = 0; j < k; j++) {
                    stack.pop();
                }
            }
        }

        String result = "";

        while (!stack.isEmpty()) {
            Map.Entry<Character, Integer> top = stack.pop();
            result = top.getKey() + result;
        }

        return result;
    }
}
