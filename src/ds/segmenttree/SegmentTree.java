package ds.segmenttree;

public class SegmentTree<E> {
    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] nums, Merger<E> merger) {
        this.merger = merger;

        data = (E[]) new Object[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i] = nums[i];
        }

        tree = (E[]) new Object[4 * nums.length]; // max nodes
        buildSegmentTree(0, 0, data.length - 1);
    }

    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l > r) {
            throw new IllegalArgumentException("Array index out of bounds");
        }
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

    public E query(int qL, int qR) {
        if (qL < 0 || qR > data.length - 1 || qL > qR) {
            throw new IllegalArgumentException("Query index out of bounds");
        }
        return query(0, qL, qR, 0, data.length - 1);
    }

    private E query(int treeIndex, int qL, int qR, int l, int r) {
        if ((qL == l && qR == r)) {
            return tree[treeIndex];
        }

        int mid = (l + r) >>> 1;
        int leftChildIndex = leftChildIndex(treeIndex);
        int rightChildIndex = rightChildIndex(treeIndex);

        if (qL <= mid && qR <= mid) { // can be simplified if checked boundary in caller
            return query(leftChildIndex, qL, qR, l, mid);
        } else if (qL > mid && qR > mid) {
            return query(rightChildIndex, qL, qR, mid + 1, r);
        } else {
            return merger.merge(
                    query(leftChildIndex, qL, mid, l, mid),
                    query(rightChildIndex, mid + 1, qR, mid + 1, r)
            );
        }
    }

    public void update(int index, E e) {
        if (index < 0 || index > data.length - 1) {
            throw new IllegalArgumentException("Update index out of bounds");
        }
        update(0, 0, data.length - 1, index, e);
    }

    private void update(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }

        int mid = (l + r) >>> 1;
        int leftChildIndex = leftChildIndex(treeIndex);
        int rightChildIndex = rightChildIndex(treeIndex);

        if (index <= mid) {
            update(leftChildIndex, l, mid, index, e);
        } else {
            update(rightChildIndex, mid + 1, r, index, e);
        }
        tree[treeIndex] = merger.merge(tree[leftChildIndex], tree[rightChildIndex]);
    }

    public int getSize() {
        return data.length;
    }

    public E getIndex(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Array index out of bounds");
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
