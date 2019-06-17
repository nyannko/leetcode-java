class BTree {
    private static final int M = 3; // number of degree(children)
    private Node root;
    private int height;
    private int size;

    public BTree() {
        this.root = new Node(0);
    }

    private class Node {
        int num;
        // num < M. if num > M: split node
        Child[] children = new Child[M]; // a list of children

        public Node(int num) { // the number of children
            this.num = num;
        }
    }

    private class Child {
        private int key;
        private int val;
        private Node next;

        public Child(int key, int val, Node node) {
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

    public int get(int key) {
        // range check here
        return search(root, key, height);
    }

    private int search(Node node, int key, int height) {
        Child[] children = node.children;

        // search external nodes
        if (height == 0) {
            for (int i = 0; i < children.length; i++) {
                if (key == getKey(children[i]))
                    return children[i].val;
            }
        }

        // search internal nodes
        else {
            for (int i = 0; i < children.length; i++) {
                // compare i with i + 1; or going down to the last node
                if (i + 1 == size || key < getKey(children[i + 1])) {
                    return search(children[i].next, key, height - 1);
                }
            }
        }
        return -1; // not found
    }


    public void put(int key, int val) {
        // range check here
        Node newNode = insert(root, key, val, height);
        size++;
        if (newNode == null) return;

        // split root node
        Node newRoot = new Node(2);
        newRoot.children[0] = new Child(getKey(root.children[0]), 0, root);
        newRoot.children[1] = new Child(getKey(newNode.children[0]), 0, newNode);
        root = newRoot;
        height++;
    }

    private Node insert(Node node, int key, int val, int height) {
        int pointer; // record the place to insert key
        Child newChild = new Child(key, val, null);
        Child[] children = node.children;
        int ChildNum = node.children.length;
        int actualChildLength = node.num;

        // external node
        if (height == 0) {
            for (pointer = 0; pointer < ChildNum - 1; pointer++) {
                if (key < getKey(children[pointer])) break;
            }
        }

        // internal node
        else {
            for (pointer = 0; pointer < ChildNum; pointer++) {
                // key between child[pointer] and child[pointer + 1] or last child
                if (key < children[pointer + 1].key || (pointer + 1 == ChildNum)) {
                    Node fromLowLevel = insert(children[pointer].next, key, val, height - 1);
                    pointer++;
                    if (fromLowLevel == null) return null;
                    newChild.key = fromLowLevel.children[0].key;
                    newChild.next = fromLowLevel;
                    break;
                }
            }
        }

        // add new element and check
        for (int i = actualChildLength; i > pointer; i--) {
            children[i] = children[i - 1]; // right shift elements
        }
        children[pointer] = newChild; // insert new Child
        node.num++; // length increment
        // check overflow
        if (node.num < M) return null;
        else return split(node);
    }

    // copy and return the last part
    private Node split(Node original) {
        Node last = new Node(M / 2);
        for (int i = 0; i < M / 2; i++) {
            last.children[i] = original.children[M / 2 + i];
        }
        return last;
    }

    private int getKey(Child c) {
        if (c == null) return 0;
        else return c.key;
    }

    public static void main(String[] args) {
        BTree b = new BTree();
        b.put(1, 2);
        b.put(2, 3);
        System.out.println(b.get(3));
    }

}
