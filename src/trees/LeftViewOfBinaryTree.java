package trees;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static trees.BinaryTreeTraversal.preorder;

public class LeftViewOfBinaryTree {
    private static void log(Object printable) { System.out.println(printable); }

    private static BinaryTreeNode<String> testCase() {
        BinaryTreeNode root = new BinaryTreeNode("A"),
                nodeB = new BinaryTreeNode("B"),
                nodeC = new BinaryTreeNode("C"),
                nodeD = new BinaryTreeNode("D"),
                nodeE = new BinaryTreeNode( "E"),
                nodeF = new BinaryTreeNode("F"),
                nodeG = new BinaryTreeNode("G"),
                nodeH = new BinaryTreeNode("H"),
                nodeI = new BinaryTreeNode("I");

        root.setLeftChild(nodeB);
        root.setRightChild(nodeC);

        nodeB.setLeftChild(nodeD);
        nodeB.setRightChild(nodeE);

        nodeC.setRightChild(nodeG);

        nodeE.setRightChild(nodeF);

        nodeG.setRightChild(nodeH);

        nodeH.setLeftChild(nodeI);

        return root;
    }

    public static void main(String[] args) {
        List<String> preorderList = new LinkedList<>(),
                lefView = new LinkedList<>(),
                rightView = new LinkedList<>();

        preorder(testCase(), preorderList);
        log("Preorder = " + preorderList.stream().collect(Collectors.joining(", ")));

        solution(testCase(), 0, lefView);
        log("Left view = " + lefView.stream().collect(Collectors.joining(", ")));

        rightViewSolution(testCase(), 0, rightView);
        log("Right view = " + rightView.stream().collect(Collectors.joining(", ")));
    }

    private static void solution(BinaryTreeNode node, int level, List result) {

        if(node == null) {
            return;
        }

        if (result.size() == level)
            result.add(node.getData());

        solution(node.getLeftChild(), level + 1, result);
        solution(node.getRightChild(), level + 1, result);
    }

    private static void rightViewSolution(BinaryTreeNode node, int level, List result) {
        if(node == null) {
            return;
        }

        if(result.size() == level) {
            result.add(node.getData());
        }

        // Inverted preorder traversal: Root -> Right subtree -> Left subtree
        solution(node.getRightChild(), level + 1, result);
        solution(node.getLeftChild(), level + 1, result);
    }
}
