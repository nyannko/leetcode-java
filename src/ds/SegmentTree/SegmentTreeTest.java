package ds.SegmentTree;

public class SegmentTreeTest {
    public static void main(String[] args) {
        Integer[] nums = {0, 1, 2, 3, 4, 5, 6, 7};
        SegmentTree<Integer> segTree = new SegmentTree<>(nums, new Merger<>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });
        System.out.println(segTree);
//      [28, 6, 22, 1, 5, 9, 13, 0, 1, 2, 3, 4, 5, 6, 7,
//      null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null]
        System.out.println(segTree.query(0, 7)); //28
        System.out.println(segTree.query(2, 5)); //14
        segTree.update(7, 10);
        System.out.println(segTree.query(0, 7)); //31
        System.out.println(segTree);
//        Exceptions:
//        System.out.println(segTree.query(-1, 5));
//        System.out.println(segTree.query(-1, -2));
//        System.out.println(segTree.query(8, 10));
//        System.out.println(segTree.query(7, 8));
//        System.out.println(segTree.query(7, 6));
    }
}
