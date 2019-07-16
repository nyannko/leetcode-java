package ds.SegmentTree;

public class SegmentTree<E> {
    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;

        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }

        tree = (E[]) new Object[4 * arr.length]; // max nodes
        buildSegmentTree(0, 0, data.length - 1);
    }

    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }

        int leftTreeIndex = leftChildIndex(treeIndex);
        int rightTreeIndex = rightChildIndex(treeIndex);

        int mid = (l + r) >>> 1;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize() {
        return data.length;
    }

    public E getIndex(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Array index out of bound");
        }
        return data[index];
    }

    private int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int rightChildIndex(int index) {
        return 2 * index + 2;
    }

    public String toString() {
        int iMax = tree.length - 1;
        StringBuffer sb = new StringBuffer();
        sb.append('[');
        for (int i = 0; ; i++) {
            if (tree[i] == null) sb.append("null");
            else sb.append(tree[i]);
            if (i == iMax) return sb.append(']').toString();
            sb.append(", ");
        }
    }

}
