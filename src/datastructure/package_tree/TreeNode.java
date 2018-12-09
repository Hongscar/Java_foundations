package datastructure.package_tree;

public class TreeNode<E extends Comparable<E>> {
    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;

    public TreeNode(E e) {
        element = e;
    }
}
