package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;


public class RearrangeForLargestNumber {
    static Comparator<Integer> lexographicalNumberComprator;

    static {
        lexographicalNumberComprator = (num1, num2) -> {
            String str1 = num1.toString(),
                str2 = num2.toString();

            if(str1.length() == str2.length())
                return str2.compareTo(str1);

            if(str1.length() > str2.length()) {
                for(int i = 0; i < str1.length() - str2.length(); i++)
                    str2 += '9';
            } else {
                for(int i = 0; i < str2.length() - str1.length(); i++)
                    str1 += '9';
            }

            return str2.compareTo(str1);
        };
    }

    public static void main(String[] args) {
        int[] test = { 1, 34, 3, 98, 9, 76, 45, 4 };
        long result = largestNumber(test);
        log(result);
    }

    private static void log(Object printable) { System.out.println(printable); }

    static long largestNumber(int[] numbers) {
        String str = Arrays.stream(numbers).mapToObj(Integer::valueOf)
                .sorted(lexographicalNumberComprator)
                .map(i -> i.toString())
                .collect(Collectors.joining(""));

        return Long.valueOf(str);
    }
}
