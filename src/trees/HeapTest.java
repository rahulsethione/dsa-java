package trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static trees.BinaryTreeTraversal.preorder;

public class HeapTest {
    private static void log(Object printable) { System.out.println(printable); }

    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};
        Integer[] integerArr = Arrays.stream(arr).mapToObj(Integer::valueOf).collect(Collectors.toList()).toArray(new Integer[arr.length]);
        Heap<Integer> maxHeap = new MaxHeap<>(integerArr);
        List<Integer> preorderList = new LinkedList<>();

        preorder(maxHeap.treeRoot, preorderList);
        log("Preorder " + preorderList.stream().map(i -> i.toString()).collect(Collectors.joining(", ")));

        maxHeap.add(15);
        List<Integer> updatedPreorderList = new LinkedList<>();
        preorder(maxHeap.treeRoot, updatedPreorderList);
        log("Preorder (after inserting 15) " + updatedPreorderList.stream().map(i -> i.toString()).collect(Collectors.joining(", ")));

        maxHeap.remove(10);
        List<Integer> reducedPreorderList = new LinkedList<>();
        preorder(maxHeap.treeRoot, reducedPreorderList);
        log("Preorder (after removing 10) " + reducedPreorderList.stream().map(i -> i.toString()).collect(Collectors.joining(", ")));
    }
}
