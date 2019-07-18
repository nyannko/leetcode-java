package ds.bstree;

public class BSTree<K extends Comparable<K>, V> {

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private int height;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.height = 1;
        }
    }

    private Node root;
    private int size;

    public BSTree() {
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
            node.value = value; // update value
        }

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

        if (node.key.equals(key)) { // notice use .equals()
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }
}

