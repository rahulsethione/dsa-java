package linkedlists;

import java.util.function.Consumer;

public class LinkedListNode<T> {
    public T data;
    public LinkedListNode nextNode;

    public LinkedListNode(T data) {
        this.data = data;
    }

    public static class LinkedListBuilder {
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

    public static <Type> LinkedListNode<Type> from(Type[] array) {
        if(array.length == 0) { return null; }

        LinkedListNode<Type> start, node;

        start = node = new LinkedListNode<>(array[0]);

        for(int i = 1; i < array.length; i++) {
            node.nextNode = new LinkedListNode(array[i]);
            node = node.nextNode;
        }

        return start;
    }

    public static void forEach(LinkedListNode startNode, Consumer consumer) {
        if(startNode == null) { return; }

        LinkedListNode node = startNode;

        while (node != null) {
            consumer.accept(node.data);
            node = node.nextNode;
        }
    }

    public static LinkedListNode reverse(LinkedListNode startNode) {

        if(startNode == null || startNode.nextNode == null) { return null; }

        LinkedListNode target = startNode;
        LinkedListNode next = startNode.nextNode;

        while (next != null) {
            LinkedListNode temp = next.nextNode;
            next.nextNode = target;
            target = next;
            next = temp;
        }

        startNode.nextNode = null;

        return target;
    }

    public static Object removeFromEnd(LinkedListNode head, int n) {
        LinkedListNode dummy = new LinkedListNode(null);

        dummy.nextNode = head;

        LinkedListNode node = dummy,
                jumper = dummy;

        for(int i = 1; i <= n + 1; i++) {
            jumper = jumper.nextNode;
        }

        while(jumper != null) {
            jumper = jumper.nextNode;
            node = node.nextNode;
        }

        Object data = node.nextNode.data;
        node.nextNode = node.nextNode.nextNode;

        return data;
    }

    public static LinkedListNode rotateRight(LinkedListNode startNode, int k) {
        if(startNode == null || startNode.nextNode == null) {
            return startNode;
        }

        LinkedListNode endNode = null;
        LinkedListNode node = startNode;
        int n = 1;

        while (node.nextNode != null) {
            node = node.nextNode;
            n++;
        }

        endNode = node;
        endNode.nextNode = startNode;

        node = startNode; // Re-initialize

        int diff = n - k;

        for(int i = 0; i < diff; i++) {
            node = node.nextNode;
        }

        LinkedListNode newStartNode = node.nextNode;

        node.nextNode = null;

        return newStartNode;
    }

    public static LinkedListNode sort(LinkedListNode head) {

        if(head.nextNode == null) {
            return head;
        }

        LinkedListNode middle = middle(head);
        LinkedListNode secondHead = middle.nextNode;

        middle.nextNode = null;

        LinkedListNode sortedHead = sort(head);
        LinkedListNode secondSortedHead = sort(secondHead);

        return merge(sortedHead, secondSortedHead);
    }

    public static LinkedListNode middle(LinkedListNode head) {
        LinkedListNode node = head,
                fastNode = head;

        while(fastNode != null && fastNode.nextNode != null && fastNode.nextNode.nextNode != null) {
            node = node.nextNode;
            fastNode = fastNode.nextNode;
            if(fastNode != null) {
                fastNode = fastNode.nextNode;
            }
        }

        return node;
    }

    private static LinkedListNode merge(LinkedListNode list1, LinkedListNode list2) {
        LinkedListNode node1 = list1,
                node2 = list2;

        LinkedListBuilder builder = new LinkedListBuilder();

        while(node1 != null || node2 != null) {
            if(node1 == null) {
                builder.add(node2.data);
                node2 = node2.nextNode;
            } else if(node2 == null) {
                builder.add(node1.data);
                node1 = node1.nextNode;
            } else {
                if((int) node1.data < (int) node2.data) {
                    builder.add(node1.data);
                    node1 = node1.nextNode;
                } else {
                    builder.add(node2.data);
                    node2 = node2.nextNode;
                }
            }
        }

        return builder.build();
    }
}
