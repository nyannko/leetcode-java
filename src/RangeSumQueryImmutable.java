import java.util.Arrays;

public class RangeSumQueryImmutable {

    private int[] tree;
    private int[] nums;
    private int numSize;

    public RangeSumQueryImmutable(int[] nums) {
        this.nums = nums;
        numSize = nums.length;
        tree = new int[numSize * 4]; // proper space!
        buildSegmentTree(0, 0, numSize - 1);
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

    // query
    public int sumRange(int i, int j) {
        if (i > j || i < 0 || j > numSize - 1) {
            throw new IllegalArgumentException("Query index out of bounds");
        }
        return query(0, i, j, 0, numSize - 1);
    }

    private int query(int treeIndex, int qL, int qR, int l, int r) {
        if (qL == l && qR == r) return tree[treeIndex];

        int leftChildIndex = treeIndex * 2 + 1;
        int rightChildIndex = treeIndex * 2 + 2;

        int mid = (l + r) >>> 1;
        if (qR <= mid) {
            return query(leftChildIndex, qL, qR, l, mid);
        } else if (qL > mid) {
            return query(rightChildIndex, qL, qR, mid + 1, r);
        } else {
            return query(leftChildIndex, qL, mid, l, mid) +
                    query(rightChildIndex, mid + 1, qR, mid + 1, r);
        }
    }

    public static void main(String[] args) {
        RangeSumQueryImmutable r = new RangeSumQueryImmutable(new int[]{0, 1, 2, 3, 4, 5, 6, 7});
        System.out.println(Arrays.toString(r.tree));
        System.out.println(r.sumRange(0, 7));
        System.out.println(r.sumRange(0, 3));
        System.out.println(r.sumRange(2, 5));
    }

    // second solution O(1)
//    private int[] sum;

//    public RangeSumQueryImmutable(int[] nums) {
//        if(nums == null || nums.length == 0) return;
//        sum = new int[nums.length + 1];
//        for (int i = 1; i < sum.length; i++) {
//            sum[i] = sum[i - 1] + nums[i - 1];
//        }
//    }
//
//    public int sumRange1(int i, int j) {
//        if (i < 0 | j > sum.length - 2 || i > j) return -1;
//        return sum[j + 1] - sum[i];
//    }

}
