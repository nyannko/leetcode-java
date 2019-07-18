package ds.btree;

import java.util.ArrayList;

class BTree<K extends Comparable<K>, V> {
    private static final int M = 3; // number of degree(children)
    private Node root;
    private int height;
    private int size;

    public BTree() {
        this.root = new Node(0);
    }

    private class Node {
        private int num;
        // num < M. if num > M: split node
//        Child[] children = new Child[M]; // a list of children
        // use list to avoid creating generics arrays
        ArrayList<Child> children;

        public Node(int num) { // the number of children
            this.num = num;
            children = new ArrayList<>();
        }
    }

    private class Child {
        private K key;
        private V val;
        private Node next;

        public Child(K key, V val, Node node) {
            this.key = key;
            this.val = val;
            this.next = node;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getHeight() {
        return height;
    }

    public int getSize() {
        return size;
    }

    public V get(K key) {
        // range check here
        return search(root, key, height);
    }

    private V search(Node node, K key, int height) {
//        Child[] children = node.children;
        ArrayList<Child> children = node.children;

        // search external nodes
        if (height == 0) {
            for (int i = 0; i < node.num; i++) {
                if (key == children.get(i).key)
                    return children.get(i).val;
            }
        }

        // search internal nodes
        else {
            for (int i = 0; i < node.num; i++) {
                // compare i with i + 1; or going down to the last node
                if (i + 1 == node.num || key.compareTo(children.get(i + 1).key) < 0) {
                    return search(children.get(i).next, key, height - 1);
                }
            }
        }
        return null; // not found
    }


    public void put(K key, V val) {
        // range check here
        Node newNode = insert(root, key, val, height);
        size++;
        if (newNode == null) return;

        // split root node
        Node newRoot = new Node(2);
        newRoot.children.add(0, new Child(root.children.get(0).key, null, root));
        newRoot.children.add(1, new Child(newNode.children.get(0).key, null, newNode));
        root = newRoot;
        height++;
    }

    private Node insert(Node node, K key, V val, int height) {
        int pointer; // record the place to insert key
        Child newChild = new Child(key, val, null);

        // external node
        if (height == 0) {
            for (pointer = 0; pointer < node.num; pointer++) {
                if (key.compareTo(node.children.get(pointer).key) < 0) break;
            }
        }

        // internal node
        else {
            for (pointer = 0; pointer < node.num; pointer++) {
                // key between child[pointer] and child[pointer + 1] or last child
                if ((pointer + 1 == node.num) || key.compareTo(node.children.get(pointer + 1).key) < 0) {
                    Node fromLowLevel = insert(node.children.get(pointer).next, key, val, height - 1);
                    pointer++;
                    if (fromLowLevel == null) return null;
                    newChild.key = fromLowLevel.children.get(0).key;
                    newChild.next = fromLowLevel;
                    break;
                }
            }
        }

        // add new element and check
        for (int i = node.num; i > pointer; i--) {
            node.children.add(i, node.children.get(i - 1)); // right shift elements
        }
        node.children.add(pointer, newChild); // insert new Child
        node.num++; // length increment
        // check degree overflow
        if (node.num < M) return null;
        else return split(node);
    }

    // copy and return the last part
    private Node split(Node original) {
        int lastNum = (int) Math.ceil((double) M / 2); // second part is larger if M is odd
        Node last = new Node(lastNum);
        original.num = M / 2;
        for (int i = 0; i < lastNum; i++) {
            last.children.add(i, original.children.get(M / 2 + i));
        }
        return last;
    }

    public static void main(String[] args) {
        BTree b = new BTree();
        for (int i = 1; i < 10; i++) {
            b.put(i, i);
            System.out.println("Find value: " + b.get(i));
        }
    }
}