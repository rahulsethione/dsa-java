package generics;

import java.util.Arrays;
import java.util.stream.Collectors;

public class GenericsTest {
    private static void log(Object printable) { System.out.println(printable); }
    public static void main(String[] args) {
        SortedLinkedList<Integer> sortedLinkedList = new SortedLinkedList<>();

        sortedLinkedList.add(10);
        sortedLinkedList.add(5);
        sortedLinkedList.add(20);
        sortedLinkedList.add(15);
        sortedLinkedList.add(10);
        sortedLinkedList.add(30);

        Integer[] arr = sortedLinkedList.toArray(new Integer[sortedLinkedList.size()]);
        String str = Arrays.stream(arr).mapToInt(Integer::valueOf).mapToObj(Integer::toString).collect(Collectors.joining(", "));

        log(str);
    }
}
