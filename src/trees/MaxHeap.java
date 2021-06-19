package trees;

public class MaxHeap<T extends Comparable<T>> extends Heap<T> {

    public MaxHeap(T[] arr) {
        super(arr);
    }

    @Override
    int comparator(T t1, T t2) {
        return t1.compareTo(t2);
    }
}
