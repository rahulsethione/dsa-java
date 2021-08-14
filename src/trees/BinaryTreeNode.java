package trees;

public class BinaryTreeNode<T> {
    private T data;
    private BinaryTreeNode<T> leftChild, rightChild;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    public BinaryTreeNode(T data, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public BinaryTreeNode copySubtree(BinaryTreeNode node) {
        if(node == null) return null;

        BinaryTreeNode copy = new BinaryTreeNode(node.getData());

        if(node.getLeftChild() != null) {
            copy.setLeftChild(copySubtree(node.getLeftChild()));
        }

        if (node.getRightChild() != null) {
            copy.setRightChild(copySubtree(node.getRightChild()));
        }

        return copy;
    }

    public void invert() {
        if(isLeaf()) return;

        BinaryTreeNode temp = rightChild;
        rightChild = leftChild;
        leftChild = temp;

        if(leftChild != null)
            leftChild.invert();

        if(rightChild != null)
            rightChild.invert();
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }
}
