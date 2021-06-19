package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class StreamVsForLoop {
    private static void log(Object printable) { System.out.println(printable); }

    public static void main(String[] args) {
        List<String> months = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");

        streaming(months);
        looping(months);

        log(streaming(months, true));
        log(looping(months, true));
    }

    static void streaming(List<String> list) {
        list.stream()
                .filter(month -> {
                    log(month);
                    return month.startsWith("J") || month.startsWith("A");
                })
                .map(month -> {
                    log("J&A " + month);
                    return month;
                })
                .collect(Collectors.toList());
    }

    static void looping(List<String> list) {
        List monthJnA = new ArrayList();
        for (String month: list) {
            if(month.startsWith("J") || month.startsWith("A")) monthJnA.add(month);
        }
    }

    static long streaming(List<String> list, boolean speedTest) {
        long start = new Date().getTime();
        list.stream()
                .filter(month -> month.startsWith("J") || month.startsWith("A"))
                .collect(Collectors.toList());
        long end = new Date().getTime();

        return end - start;
    }

    static long looping(List<String> list, boolean speedTest) {
        long start = new Date().getTime();
        List monthJnA = new ArrayList();
        for (String month: list) {
            if(month.startsWith("J") || month.startsWith("A")) monthJnA.add(month);
        }
        long end = new Date().getTime();

        return end - start;
    }


}
