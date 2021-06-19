package generics;

import linkedlists.LinkedListNode;

public class SortedLinkedList<T extends Comparable<T>> {
    private LinkedListNode<T> startNode;
    private int listSize;

    public int size() {
        return listSize;
    }

    public int add(T nodeData) {
        if(startNode == null) {
            startNode = new LinkedListNode<>(nodeData);
            listSize++;
            return 0;
        }

        LinkedListNode<T> next = startNode, prev = null;
        LinkedListNode<T> toBeInserted = new LinkedListNode<>(nodeData);
        int position = 0;

        try {
            listSize++;
            while (next != null && nodeData.compareTo(next.data) > 0) {
                prev = next;
                next = next.nextNode;
                position++;
            }

            if(prev == null) {
                toBeInserted.nextNode = startNode;
                startNode = toBeInserted;
                return 0;
            }

            prev.nextNode = toBeInserted;
            toBeInserted.nextNode = next;
            return position;
        } catch (Exception ex) {
            listSize--;
            throw ex;
        }
    }

    public int indexOf(T nodeData) {

        LinkedListNode<T> node = startNode;
        int index = 0;

        while (node != null) {
            if(node.data.equals(nodeData)) { return index; }

            index++;
        }

        return -1;
    }

    public T[] toArray(T[] targetArray) {

        LinkedListNode<T> node = startNode;
        int index = 0;

        while (node != null && index < targetArray.length) {
            targetArray[index] = node.data;
            node = node.nextNode;
            index++;
        }

        return targetArray;
    }
}
