package linkedlists;

public class SortTest {
    public static void main(String[] args) {
        LinkedListBuilder builder = new LinkedListBuilder();

        LinkedListNode head = builder
                .add(10)
                .add(5)
                .add(1)
                .add(7)
                .add(9)
                .add(3)
                .build();

        LinkedListNode sortedList = LinkedListNode.sort(head);

        return;
    }
}
