package numbers;

import java.util.HashMap;
import java.util.Map;

public class RecurringSequenceInFraction {
    public static void main(String[] args) {
        int num = 5, div = 3;

        int num1 = 50, div1 = 22;

        String recurringSeq = recurringSequenceInFraction(num, div);
        String recurringSeq1 = recurringSequenceInFraction(num1, div1);

        log(recurringSeq);
        log(recurringSeq1);
    }

    private static void log(Object printable) { System.out.println(printable); }

    static String recurringSequenceInFraction(int num, int div) {
        String fraction = "";
        int rem = num % div;
        Map<Integer, Integer> map = new HashMap<>();

        while(rem != 0 && !map.containsKey(rem)) {
            map.put(rem, fraction.length());

            rem = rem * 10;

            int intValue = rem / div;
            fraction += String.valueOf(intValue);

            rem = rem % div;
        }

        if(rem == 0) {
            return "";
        }

        return fraction.substring(map.get(rem));
    }
}
