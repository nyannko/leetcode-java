import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        q.add(root);
        res.add(new ArrayList<>(Arrays.asList(root.val)));

        while (!q.isEmpty()) {
            int size = q.size(); // compute queue size here..
            List<Integer> val = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode ele = q.poll();
                if (ele.left != null) {
                    q.add(ele.left);
                    val.add(ele.left.val);
                }
                if (ele.right != null) {
                    q.add(ele.right);
                    val.add(ele.right.val);
                }
            }
            if (val.size() != 0) {
                res.add(val);
            }
        }
        return res;
    }
}
