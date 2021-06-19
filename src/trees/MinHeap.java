package trees;

public class MinHeap<T extends Comparable<T>> extends Heap<T> {

    public MinHeap(T[] arr) {
        super(arr);
    }

    @Override
    int comparator(T t1, T t2) {
        return t2.compareTo(t1);
    }
}
