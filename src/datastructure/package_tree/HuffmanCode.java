package datastructure.package_tree;

import datastructure.package_list.Node;
import someObj.Heap;

import java.util.Scanner;

public class HuffmanCode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = input.nextLine();

        int[] counts = getCharacterFrequency(text);

        System.out.printf("%-15s%-15s%-15s%-15s\n",
                "ASCII Code", "Character", "Frequency", "Code");

        Tree tree = getHuffmanTree(counts);
        String[] codes = getCode(tree.root);

        for (int i = 0; i < codes.length; i++) {
            if (counts[i] != 0)
                System.out.printf("%-15d%-15s%-15d%-15s\n",
                        i, (char)i + "", counts[i], codes[i]);
        }

    }

    public static class Tree implements Comparable<Tree> {
        Node root;

        public Tree(Tree t1, Tree t2) {
            root = new Node();
            root.left = t1.root;
            root.right = t2.root;
            root.weight = t1.root.weight + t2.root.weight;
        }

        public Tree(int weight, char element) {
            root = new Node(weight, element);
        }

        @Override
        public int compareTo(Tree t) {
            if (root.weight < t.root.weight)        //Purposely reverse the order
                return 1;
            else if (root.weight == t.root.weight)
                return 0;
            else
                return -1;
        }

        public class Node {     //inner class of Tree
            char element;
            int weight;
            Node left;
            Node right;
            String code = "";

            public Node() {

            }

            public Node(int weight, char element) {
                this.weight = weight;
                this.element = element;
            }
        }
    }

    public static int[] getCharacterFrequency(String text) {
        int[] counts = new int[256];

        for (int i = 0; i < text.length(); i++)
            counts[(int)text.charAt(i)]++;

        return counts;
    }

    public static Tree getHuffmanTree(int[] counts) {
        Heap<Tree> heap = new Heap<>();             //minimal heap
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0)
                heap.add(new Tree(counts[i], (char)i));
        }

        while (heap.getSize() > 1) {
            Tree t1 = heap.remove();        //the smallest element will remove firstly
            Tree t2 = heap.remove();
            heap.add(new Tree(t1, t2));
        }

        return heap.remove();
    }

    private static void assignCode(Tree.Node root, String[] codes) {
        if (root.left != null) {
            root.left.code = root.code + "0";
            assignCode(root.left, codes);

            root.right.code = root.code + "1";
            assignCode(root.right, codes);
        }
        else {
            codes[(int)root.element] = root.code;
        }
    }

    public static String[] getCode(Tree.Node root) {
        if (root == null) return null;
        String[] codes = new String[2 * 128];
        assignCode(root, codes);
        return codes;
    }
}
