package trees;

import java.util.Arrays;

public class MinHeap<T extends Comparable<T>> extends Heap<T> {

    public MinHeap(T[] arr) {
        super(arr);
    }

    @Override
    int comparator(T t1, T t2) {
        return t2.compareTo(t1);
    }

    public T extractMin() {
        T root = array[array.length - 1];
        T poll = array[0];

        array = Arrays.copyOf(array, array.length - 1);

        heapify(array, 0);

        treeRoot = fromArray(array, 0);

        return poll;
    }
}
