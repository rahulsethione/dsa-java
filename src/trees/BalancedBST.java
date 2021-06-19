package trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static trees.BinaryTreeTraversal.inorder;

public class BalancedBST {
    private static void log(Object printable) { System.out.println(printable); }

    public static void main(String[] args) {
        BinaryTreeNode testcaseRoot = new BinaryTreeNode(50),
                binaryTreeNode40 = new BinaryTreeNode(40),
                binaryTreeNode30 = new BinaryTreeNode(30),
                binaryTreeNode35 = new BinaryTreeNode(35),
                binaryTreeNode20 = new BinaryTreeNode(20),
                binaryTreeNode25 = new BinaryTreeNode(25),
                binaryTreeNode22 = new BinaryTreeNode(22);

        testcaseRoot.setLeftChild(binaryTreeNode40);
        binaryTreeNode40.setLeftChild(binaryTreeNode30);
        binaryTreeNode30.setRightChild(binaryTreeNode35);
        binaryTreeNode30.setLeftChild(binaryTreeNode20);
        binaryTreeNode20.setRightChild(binaryTreeNode25);
        binaryTreeNode25.setLeftChild(binaryTreeNode22);

        BinaryTreeNode balancedBSTRoot = balance(testcaseRoot);

        Object[] result = toSortedList(balancedBSTRoot);

        log(Arrays.stream(result).map(i -> ((Integer)i).toString()).collect(Collectors.joining(", ")));

        log("Is balanced BST really balanced? " + isBalancedTree(balancedBSTRoot));
        log("Is unbalanced tree balanced? " + isBalancedTree(testcaseRoot));

        log("Height of balanced BST = " + heightOfBinaryTree(balancedBSTRoot));
        log("Height of unbalanced BST = " + heightOfBinaryTree(testcaseRoot));


        BinaryTreeNode root = new BinaryTreeNode(10),
                leftChild = new BinaryTreeNode<>(5),
                    leaf = new BinaryTreeNode(2);

        root.setLeftChild(leftChild);
        leftChild.setLeftChild(leaf);

        log(isBalancedTree(root));
    }

    static BinaryTreeNode balance(BinaryTreeNode root) {
        Object[] sortedArray = toSortedList(root);

        return balanceNode(sortedArray, 0, sortedArray.length - 1);
    }

    static BinaryTreeNode balanceNode(Object[] arr, int start, int end) {
        if(start < end) {
            int centre = (end + start) / 2;

            BinaryTreeNode node = new BinaryTreeNode(arr[centre]);
            BinaryTreeNode leftChild = balanceNode(arr, start, centre - 1);
            BinaryTreeNode rightChild = balanceNode(arr, centre + 1, end);

            node.setLeftChild(leftChild);
            node.setRightChild(rightChild);

            return node;
        }

        return new BinaryTreeNode(arr[start]);
    }

    static Object [] toSortedList(BinaryTreeNode root) {
        List sortedList = new LinkedList();
        inorder(root, sortedList);
        return sortedList.toArray(new Object[sortedList.size()]);
    }

    static boolean isBalancedTree(BinaryTreeNode root) {
        return isBalancedSubtree(root);
    }

    static boolean isBalancedSubtree(BinaryTreeNode node) {
        /*
        boolean result = false;

        if(isLeafNode(node)) {
            return true;
        }

        if(node.getLeftChild() != null) {
            result = isBalancedSubtree(node.getLeftChild());
        }

        if(node.getLeftChild() != null && node.getRightChild() != null) {
            result = result && isBalancedSubtree(node.getRightChild());
        }

        return result;
        */

        if(node == null) return true;
        if(isLeafNode(node)) return true;

        int heightLeftSubtree = heightOfSubtree(node.getLeftChild()),
            heightRightSubtree = heightOfSubtree(node.getRightChild());

        return Math.abs(heightLeftSubtree - heightRightSubtree) > 1 ? false : true;
    }

    static boolean isLeafNode(BinaryTreeNode node) {
        return node.getLeftChild() == null && node.getRightChild() == null;
    }

    static int heightOfBinaryTree(BinaryTreeNode root) {
        return heightOfSubtree(root);
    }

    static int heightOfSubtree(BinaryTreeNode node) {
        if(node == null) return 0;
        if(isLeafNode(node)) return 1;

        int subtreeHeight = Math.max(
                heightOfSubtree(node.getLeftChild()) + 1,
                heightOfSubtree(node.getRightChild()) + 1
        );

        return subtreeHeight;
    }

}
