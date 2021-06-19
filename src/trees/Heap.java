package trees;

import java.util.Arrays;

public abstract class Heap<T extends Comparable<T>> {
    abstract int comparator(T t1, T t2);
    BinaryTreeNode<T> treeRoot = null;
    T[] array;

    public Heap(T[] array) {
        this.array = Arrays.copyOf(array, array.length);

        for(int i = this.array.length/2; i >= 0; i--) {
            heapify(this.array, i);
        }

        this.treeRoot = fromArray(this.array, 0);
    }

    private void heapify(T[] arr, int i) {
        int left = 2 * i + 1,
                right = 2 * i + 2;

        int largest = i;

        if(left < arr.length && comparator(arr[left], arr[largest]) > 0) {
            largest = left;
        }

        if(right < arr.length && comparator(arr[right], arr[largest]) > 0) {
            largest = right;
        }

        if(largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest);
        }
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private BinaryTreeNode<T> fromArray(T[] arr, int i) {
        if(i >= arr.length) {
            return null;
        }

        BinaryTreeNode<T> node = new BinaryTreeNode<>(arr[i]);

        int left = 2 * i + 1,
                right = 2 * i + 2;

        if(left < arr.length) {
            node.setLeftChild(fromArray(arr, left));
        }

        if(right < arr.length) {
            node.setRightChild(fromArray(arr, right));
        }

        return node;
    }

    public void add(T item) {
        int length = array.length;

        array = Arrays.copyOf(array, length + 1);
        array[length] = item;

        heapifyParent(array, length);

        treeRoot = fromArray(array, 0);
    }

    public boolean remove(T item) {
        int index = 0;
        boolean found = false;
        for(int i = 0; i < array.length; i++) {
            if(array[i].equals(item)) {
                found = true;
                index = i;
                break;
            }
        }

        if(found) {
            T root = array[array.length - 1];
            T[] copy = Arrays.copyOf(array, array.length - 1);

            copy[index] = root;
            heapify(copy, index);
            array = copy;
            treeRoot = fromArray(array, 0);
        }

        return found;
    }

    private void heapifyParent(T[] arr, int i) {
        if(i == 0) {
            return;
        }

        int parent = (i - 1) / 2;

        if(comparator(arr[i], arr[parent]) > 0) {
            swap(arr, parent, i);
            heapifyParent(arr, parent);
        }
    }

}
