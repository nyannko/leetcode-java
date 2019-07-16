package ds.SegmentTree;

public class testSegmentTree {
    public static void main(String[] args) {
        Integer[] nums = {0, 1, 2, 3, 4, 5, 6, 7};
        SegmentTree<Integer> segTree = new SegmentTree<>(nums, new Merger<>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });
        System.out.println(segTree);
//        [28, 6, 22, 1, 5, 9, 13, 0, 1, 2, 3, 4, 5, 6, 7,
//        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null]
    }
}
