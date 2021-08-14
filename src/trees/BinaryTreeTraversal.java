package trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class BinaryTreeTraversal {
    private static void log(Object printable) { System.out.println(printable); }

    private static BinaryTreeNode testCase() {
        BinaryTreeNode<String> root = new BinaryTreeNode<>("1"),
                node2 = new BinaryTreeNode<>("2"),
                node3 = new BinaryTreeNode<>("3"),
                node4 = new BinaryTreeNode<>("4"),
                node5 = new BinaryTreeNode<>("5");

        root.setLeftChild(node2);
        root.setRightChild(node3);

        node2.setLeftChild(node4);
        node2.setRightChild(node5);

        return root;
    }

    public static void main(String[] args) {
        BinaryTreeNode testcaseRoot = testCase();
        List inorderList = new LinkedList(), preorderList = new LinkedList(),
            inorderNoRecursionList = new LinkedList(), preorderNoRecursionList = new LinkedList(),
            levelOrderList = new LinkedList();

        inorder(testcaseRoot, inorderList);
        log("Inorder " + inorderList.stream().collect(Collectors.joining(", ")));

        preorder(testcaseRoot, preorderList);
        log("Preorder " + preorderList.stream().collect(Collectors.joining(", ")));

        inorderNoRecursion(testcaseRoot, inorderNoRecursionList);
        log("Inorder no-recursion " + inorderNoRecursionList.stream().collect(Collectors.joining(", ")));

        preorderNoRecursion(testcaseRoot, preorderNoRecursionList);
        log("Preorder no-recursion " + preorderNoRecursionList.stream().collect(Collectors.joining(", ")));

        preorderNoRecursion(testcaseRoot, levelOrderList);
        log("Level-order " + levelOrderList.stream().collect(Collectors.joining(", ")));
    }

    public static void inorder(BinaryTreeNode node, List inorderList) {
        if(node == null) {
            return;
        }

        if(node.getLeftChild() != null) {
            inorder(node.getLeftChild(), inorderList);
        }

        inorderList.add(node.getData());

        if(node.getRightChild() != null) {
            inorder(node.getRightChild(), inorderList);
        }
    }

    public static void preorder(BinaryTreeNode node, List preorderList) {
        if(node == null) {
            return;
        }

        preorderList.add(node.getData());
        preorder(node.getLeftChild(), preorderList);
        preorder(node.getRightChild(), preorderList);
    }

    public static void inorderNoRecursion(BinaryTreeNode root, List inorderList) {
        if(root == null) return;

        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode node = root;

        while (!stack.isEmpty() || node != null) {

            while (node != null) {
                stack.push(node);
                node = node.getLeftChild();
            }

            BinaryTreeNode top = stack.pop();

            inorderList.add(top.getData());
            node = top.getRightChild();
        }
    }

    public static void preorderNoRecursion(BinaryTreeNode root, List preorderList) {
        if(root == null) {
            return;
        }

        Stack<BinaryTreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();

            preorderList.add(node.getData());

            if(node.getRightChild() != null)
                stack.push(node.getRightChild());

            if(node.getLeftChild() != null)
                stack.push(node.getLeftChild());
        }
    }

    public static void levelOrderTraversalWithBFS(BinaryTreeNode root, List levelOrderList) {
        if(root == null) return;

        Queue<BinaryTreeNode> queue = new LinkedList();

        queue.add(root);

        while(!queue.isEmpty()) {
            BinaryTreeNode node = queue.remove();

            levelOrderList.add(node.getData());

            if(node.getLeftChild() != null)
                queue.add(node.getLeftChild());

            if(node.getRightChild() != null) {
                queue.add(node.getRightChild());
            }
        }
    }
}
