package ds.AVLTree;

import ds.BSTree.BSTree;
import ds.util.FileOperation;

import java.util.ArrayList;
import java.util.Collections;

public class AVLTree<K extends Comparable<K>, V> {

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
            node.value = value; // update value
        }

        // update height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // calculate balanced factor
        int balanceFactor = getBalanceFactor(node);
        // System.out.println("unbalanced: " + balanceFactor);

        // return LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0)
            return rightRotate(node);

        // return RR
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0)
            return leftRotate(node);

        // return LR
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // return RL
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public V remove(K key) {
        Node node = getNode(root, key);
        if (node == null) return null;
        root = remove(root, key);
        return node.value;
    }

    private Node remove(Node node, K key) {
        if (node == null) return null;
        Node retNode;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            retNode = node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            retNode = node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                // return rightNode;
                retNode = rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                // return leftNode;
                retNode = leftNode;
            } else {
                Node newNode = findMin(node.right); // find the successor
                newNode.right = remove(node.right, newNode.key); // del successor from original tree
                newNode.left = node.left;

                node.left = node.right = null;
                retNode = newNode;
            }
        }

        if (retNode == null)
            return null;

        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));

        int balanceFactor = getBalanceFactor(retNode);

        // LL
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0)
            return rightRotate(retNode);

        // RR
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0)
            return leftRotate(retNode);

        // LR
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }

        // RL
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }

        return retNode;
    }

    private Node findMin(Node node) {
        if (node.left == null)
            return node;
        return findMin(node.left);
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node newLeft = x.right;

        x.right = y;
        y.left = newLeft;

        // update height of y, x
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    private Node leftRotate(Node y) {
        Node x = y.right;
        Node newRight = x.left;

        x.left = y;
        y.right = newRight;

        // update height of y, x
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
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

    // H(left) - H(right)
    private int getBalanceFactor(Node node) {
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
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) <= 1) {
            return isBalancedTree(node.left) && isBalancedTree(node.right);
        }
        return false;
    }

    public static void testPerformance() {
        ArrayList<String> words = new ArrayList<>();

        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            AVLTree<String, Integer> avl = new AVLTree<>();
            BSTree<String, Integer> bst = new BSTree<>();
            Collections.sort(words); // binary search tree resembles linked list(degenerate tree)

            double startTime, timeElapsed;

            startTime = System.nanoTime();
            // store unique words into binary search tree
            for (String word : words) {
                if (!bst.contains(word)) {
                    bst.add(word, 1);
                } else {
                    bst.add(word, bst.get(word) + 1);
                }
            }

            for (String word : words) {
                bst.contains(word);
            }

            timeElapsed = (System.nanoTime() - startTime) / 1000000000;
            System.out.println("BST: " + timeElapsed + "s");

            startTime = System.nanoTime();
            // store unique words into AVL tree
            for (String word : words) {
                if (!avl.contains(word)) {
                    avl.add(word, 1);
                } else {
                    avl.add(word, avl.get(word) + 1);
                }
            }

            // search word
            for (String word : words) {
                avl.contains(word);
            }

            timeElapsed = (System.nanoTime() - startTime) / 1000000000;
            System.out.println("AVL: " + timeElapsed + "s");

            // KVTest result
            // BST: 17.011717567s
            // AVL: 0.065272355s
        }
    }

    public static void main(String[] args) {
        // read from file
        ArrayList<String> words = new ArrayList<>();

        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            AVLTree<String, Integer> avl = new AVLTree<>();

            long startTime, timeElapsed;

            startTime = System.nanoTime();
            // store unique words into AVL tree
            for (String word : words) {
                if (!avl.contains(word)) {
                    avl.add(word, 1);
                } else {
                    avl.add(word, avl.get(word) + 1);
                }
            }

            // search word
            for (String word : words) {
                avl.contains(word);
            }

            timeElapsed = (System.nanoTime() - startTime) / 1000000000;
            System.out.println("AVL: " + timeElapsed + "s");

            System.out.println("Unique words:" + avl.getSize());
            System.out.println("Frequency of PRIDE: " + avl.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + avl.get("prejudice"));

            System.out.println("is Binary search tree: " + avl.isBST()); // true
            System.out.println("is Balanced tree: " + avl.isBalancedTree()); // true

            for (String word : words) {
                avl.remove(word);
                if (!avl.isBST() || !avl.isBalancedTree())
                    throw new RuntimeException();
            }
        }
        testPerformance();
    }
}
