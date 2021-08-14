package linkedlists;

public class MergeSortedLinkedList {
    public static void main(String[] args) {
       LinkedListBuilder builder1 = new LinkedListBuilder(),
               builder2 = new LinkedListBuilder();

       LinkedListNode list1 = builder1.add(4).add(8).add(15).add(19).build(),
            list2 = builder2.add(7).add(9).add(10).add(16).build();

       LinkedListNode mergedList = merge(list1, list2);
       return;
    }

    static LinkedListNode merge(LinkedListNode list1, LinkedListNode list2) {
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
