package ds.AVLTree;

import java.util.ArrayList;

public class AVLTree<K extends Comparable<K>, V> {

    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;
        private int height;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private int getHeight(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }

        // update height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // calculate balanced factor
        int balanceFactor = getBalancedFactor(node);
        System.out.println("unbalanced: " + balanceFactor);

        return node;
    }

    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    // get value
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    // set value
    public void set(K key, V value) {
        Node node = getNode(root, key);

        if (node == null) return;
        node.value = value;
    }

    private Node getNode(Node node, K key) {
        if (node == null) return null;

        if (node.key.equals(key)) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    // H(left) - H(right)
    private int getBalancedFactor(Node node) {
        return getHeight(node.left) - getHeight(node.right);
    }

    public boolean isBST() {
       ArrayList<K> keys = new ArrayList<>();
       inOrder(root, keys);
       for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i).compareTo(keys.get(i - 1)) < 0) return false;
       }
       return true;
    }

    private void inOrder(Node node, ArrayList<K> keys) {
        if (node == null) return;

        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    public boolean isBalancedTree() {
        return isBalancedTree(root);
    }

    private boolean isBalancedTree(Node node) {
        if (node == null) return true;
        int balanceFactor = getBalancedFactor(node);
        if (Math.abs(balanceFactor) <= 1) {
            return isBalancedTree(node.left) && isBalancedTree(node.right);
        }
        return false;
    }

    public static void main(String[] args) {
        // read from file
        ArrayList<String> words = new ArrayList<>();

        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            AVLTree<String, Integer> avl = new AVLTree<>();

            // store unique words into the tree
            for (String word : words) {
                if (!avl.contains(word)) {
                    avl.add(word, 1);
                } else {
                    avl.add(word, avl.get(word) + 1);
                }
            }

            System.out.println("Unique words:" + avl.getSize());
            System.out.println("Frequency of PRIDE: " + avl.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + avl.get("prejudice"));

            System.out.println("is Binary search tree: " + avl.isBST());
            System.out.println("is Balanced tree: " + avl.isBalancedTree());
        }
    }
}
