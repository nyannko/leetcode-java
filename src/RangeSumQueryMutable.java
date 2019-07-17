import java.util.Arrays;

public class RangeSumQueryMutable {

    private int[] nums;
    private int[] tree;
    private int size;

    public RangeSumQueryMutable(int[] nums) {
        this.nums = nums;
        size = nums.length;
        tree = new int[size * 4];
        buildSegmentTree(0, 0, size - 1);
    }

    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l > r) {
            throw new IllegalArgumentException("Array index out of bounds");
        }
        if (l == r) {
            tree[treeIndex] = nums[l];
            return;
        }

        int leftChildIndex = treeIndex * 2 + 1;
        int rightChildIndex = treeIndex * 2 + 2;
        int mid = (l + r) >>> 1;

        buildSegmentTree(leftChildIndex, l, mid);
        buildSegmentTree(rightChildIndex, mid + 1, r);

        tree[treeIndex] = tree[leftChildIndex] + tree[rightChildIndex];
    }

    public void update(int i, int val) {
        if (i < 0 || i > size - 1) return;
        update(0, 0, size - 1, i, val);
    }

    private void update(int treeIndex, int l, int r, int index, int val) {
        if (l == r) {
            tree[treeIndex] = val;
            return;
        }

        int leftChildIndex = 2 * treeIndex + 1;
        int rightChildIndex = 2 * treeIndex + 2;
        int mid = (l + r) >>> 1;

        if (index <= mid) {
            update(leftChildIndex, l, mid, index, val);
        } else {
            update(rightChildIndex, mid + 1, r, index, val);
        }

        tree[treeIndex] = tree[leftChildIndex] + tree[rightChildIndex];
    }

    public int sumRange(int i, int j) {
        if (i < 0 || j > size - 1 || i > j) return -1;
        return query(0, i, j, 0, size - 1);
    }

    private int query(int treeIndex, int i, int j, int l, int r) {
        if (i == l && j == r) return tree[treeIndex];

        int leftChildIndex = 2 * treeIndex + 1;
        int rightChildIndex = 2 * treeIndex + 2;
        int mid = (l + r) >>> 1;

        if (j <= mid) {
            return query(leftChildIndex, i, j, l, mid);
        } else if (i > mid) {
            return query(rightChildIndex, i, j, mid + 1, r);
        } else {
            return query(leftChildIndex, i, mid, l, mid) +
                    query(rightChildIndex, mid + 1, j, mid + 1, r);
        }
    }

    public static void main(String[] args) {
        RangeSumQueryMutable r = new RangeSumQueryMutable(new int[]{0, 1, 2, 3, 4, 5, 6, 7});
        RangeSumQueryMutable r1 = new RangeSumQueryMutable(new int[]{1, 3, 5});
        System.out.println(r1.sumRange(0, 2));
        System.out.println(Arrays.toString(r1.tree));
        r1.update(1, 2);
        System.out.println(Arrays.toString(r1.tree));
        System.out.println(r1.sumRange(0, 2));
        System.out.println(Arrays.toString(r.tree));
        System.out.println(r.sumRange(0, 7));
        r.update(7, 10);
        System.out.println(r.sumRange(0, 7));
    }

}
