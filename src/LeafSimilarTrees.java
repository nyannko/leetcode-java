import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = new ArrayList<>(),
                      res2 = new ArrayList<>();
        findLeaf(root1, res1);
        findLeaf(root2, res2);
        return res1.equals(res2);
    }

    public void findLeaf(TreeNode root, List<Integer> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) res.add(root.val);
        findLeaf(root.left, res);
        findLeaf(root.right, res);
    }
}
