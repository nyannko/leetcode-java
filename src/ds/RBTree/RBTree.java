package ds.RBTree;

public class RBTree<K extends Comparable<K>, V> {

    private final static boolean RED = true;
    private final static boolean BLACK = false;

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private int height;
        private boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.height = 1;
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
            node.right = add(node.left, key, value);
        } else {
            node.value = value; // update value
        }

        return node;
    }
}
