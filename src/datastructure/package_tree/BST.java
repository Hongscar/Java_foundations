package datastructure.package_tree;

import java.util.ArrayList;
import java.util.Iterator;

public class BST<E extends Comparable<E>> extends AbstractTree<E>{
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {

    }

    public BST(E[] objects) {
        //super(objects); //err?
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    @Override
    public boolean search(E e) {
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            }
            else if (e.compareTo(current.element) > 0) {
                current = current.right;
            }
            else {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e);
        else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                }
                else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                }
                else
                    return false;   //Duplicate node not inserted
            }

            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }

        size++;
        return true;
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);    //so beautiful recursion!
    }

    @Override
    public void postorder() {
        postorder(root);
    }

    protected void postorder(TreeNode<E> root) {
//        if (root == null) return;
//        System.out.print(root.element + " ");
//        preorder(root.left);
//        preorder(root.right);
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    @Override
    public void preorder() {
        preorder(root);
    }

    protected void preorder(TreeNode<E> root) {
//        if (root == null) return;
//        postorder(root.left);
//        postorder(root.right);
//        System.out.print(root.element + " ");
        if (root == null) return;
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    @Override
    public int getSize() {
        return size;
    }

    public TreeNode<E> getRoot() {
        return root;
    }

    public ArrayList<TreeNode<E>> path(E e) {
        boolean isExist = false;
        isExist = search(e);    //search whether element e is in the tree

        if (!isExist)
            return null;

        ArrayList<TreeNode<E>> list = new ArrayList<>();
        TreeNode<E> current = root;

        while (current != null) {
            list.add(current);
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            }
            else if (e.compareTo(current.element) > 0) {
                current = current.right;
            }
            else
                break;
        }
        return list;
    }

    @Override
    public boolean delete(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;

        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            }
            else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            }
            else
                break;
        }

        if (current == null)
            return false;       //Element is not in the tree

        if (current.left == null) {
            if (parent == null)
                root = current.right;
            else {
                if (e.compareTo(parent.element) < 0)
                    parent.left = current.right;
                else
                    parent.right = current.right;
            }
        }
        else {
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }

            current.element = rightMost.element;

            if (parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else
                parentOfRightMost.left = rightMost.left;
        }

        size--;
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new InorderIterator();
    }

    private class InorderIterator implements Iterator<E> {
        private ArrayList<E> list = new ArrayList<>();
        private int current = 0;

        public InorderIterator() {
            inorder();
        }

        private void inorder() {
            inorder(root);
        }

        private void inorder(TreeNode<E> root) {
            if (root == null) return;
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
        }

        @Override
        public boolean hasNext() {
            if (current < list.size())
                return true;
            return false;
        }

        @Override
        public E next() {
            return list.get(current++);
        }

        @Override
        public void remove() {
            delete(list.get(current));
            list.clear();
            inorder();
        }
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public static void main(String[] args) {
        BST<String> tree = new BST<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");

        printTree(tree);

        tree.delete("George");
        printTree(tree);

        tree.delete("Adam");
        printTree(tree);

        tree.delete("Michael");
        printTree(tree);


        /*
        System.out.println(tree.getSize());

        System.out.println(tree.search("Peter"));

        System.out.print("The path: ");
        ArrayList<TreeNode<String>> path = tree.path("Peter");

        for (int i = 0; path != null && i < path.size(); i++)
            System.out.print(path.get(i).element + " ");

        System.out.println();
        System.out.println(tree.getRoot().element);

//        Iterator<String> iterator = tree.iterator();
//        while (iterator.hasNext())
//            System.out.println(iterator.next());


        Integer[] numbers = {2,4,3,1,8,5,6,7};
        BST<Integer> intTree = new BST<>(numbers);
        System.out.print("\nInorder: ");
        intTree.inorder();
        */
    }

    public static void printTree(BST tree) {
        System.out.print("Inorder: ");
        tree.inorder();

        System.out.print("\nPostorder: ");
        tree.postorder();

        System.out.print("\nPreorder: ");
        tree.preorder();
        System.out.println("\nThe number of nodes is " + tree.getSize());
        System.out.println();
    }
}
