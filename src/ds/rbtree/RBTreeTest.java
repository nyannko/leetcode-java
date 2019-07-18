package ds.rbtree;

// check visualization in
// http://inst.eecs.berkeley.edu/~cs61b/fa17/materials/demos/ll-red-black-demo.html
public class RBTreeTest {
    public static void main(String[] args) {
        int[][] test = {{6, 2}, {8, 6}, {6, 2, 3}, {6, 3, 2}, {6, 8, 1, 2, 3}, {6, 8, 3, 2, 1},
                {6, 8, 9, 1, 3, 12, 20, 24, 10, 11}};
        for (int[] row : test) {
            RBTree<Integer, Integer> map = new RBTree<>();
            for (int i : row) {
                map.add(i, null);
            }
            map.printRBTree();
        }
        //[6, 2(red)]
        //[8, 6(red)]
        //[3, 2, 6]
        //[3, 2, 6]
        //[6, 2(red), 1, 3, 8]
        //[6, 2(red), 1, 3, 8]
        //[8, 3, 1, 6, 12, 10(red), 9, 11, 24, 20(red)]
    }
}
