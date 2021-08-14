package linkedlists;

public class LinkedListBuilder {
    private LinkedListNode head = null;
    private LinkedListNode node = null;

    public LinkedListBuilder add(Object data) {
        if(head == null) {
            head = node = new LinkedListNode(data);
        } else {
            node.nextNode = new LinkedListNode(data);
            node = node.nextNode;
        }

        return this;
    }

    public LinkedListNode build() {
        return head;
    }
}
