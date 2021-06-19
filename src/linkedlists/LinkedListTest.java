package linkedlists;

public class LinkedListTest {
    private static void log(Object printable) { System.out.println(printable); }
    public static void main(String[] args) {
        LinkedListNode linkedListStart = LinkedListNode.from(new Integer[]{1, 2, 3, 4, 5, 6});

        LinkedListNode reversedLinkedListStart = LinkedListNode.reverse(linkedListStart);

        LinkedListNode.forEach(reversedLinkedListStart, i -> log(i));

    }
}
