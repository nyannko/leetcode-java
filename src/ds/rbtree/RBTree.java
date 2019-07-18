package ds.rbtree;

import java.util.ArrayList;

public class RBTree<K extends Comparable<K>, V> {

    private final static boolean RED = true;
    private final static boolean BLACK = false;

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.color = RED; // init with color red
        }
    }

    private Node root;
    private int size;

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private boolean isRed(Node node) {
        if (node == null) return BLACK; // instead of throw null pointer exception
        return node.color;
    }

    public void add(K key, V value) {
        root = add(root, key, value);
        root.color = BLACK; // root color is black
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
            node.value = value; // update value
        }

        // left rotate
        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }

        // right rotate
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }

        // flip color
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    private Node leftRotate(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;

        // change color
        x.color = node.color;
        node.color = RED;

        return x;
    }

    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    private Node rightRotate(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;

        // change color
        x.color = node.color;
        node.color = RED;

        return x;
    }

    public V get(K key) {
        Node node = getNode(root, key);
        if (node == null) return null;
        return node.value;
    }

    private Node getNode(Node node, K key) {
        if (node == null) return null;

        if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        }
        return node;
    }

    public void set(K key, V value) {
        Node node = getNode(root, key);
        if (node == null) return;
        node.value = value;
    }

    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    public void printRBTree() {
        ArrayList<String> keys = new ArrayList<>();
        preOrder(root, keys);
        System.out.println(keys);
    }

    private void preOrder(Node root, ArrayList<String> keys) {
        if (root == null) return;
        if (isRed(root)) keys.add(root.key + "(red)");
        else keys.add(root.key + "");
        preOrder(root.left, keys);
        preOrder(root.right, keys);
    }
}
