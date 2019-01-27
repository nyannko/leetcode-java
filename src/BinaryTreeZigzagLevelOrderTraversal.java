import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        boolean flag = false;
        q.offer(root);

        while (!q.isEmpty()) {
            int levelNum = q.size();
            List<Integer> subRes = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
                subRes.add(node.val);
            }
            if (flag == true) {
                Collections.reverse(subRes);
                flag = false;
            } else {
                flag = true;
            }
            res.add(subRes);
        }
        return res;
    }
}
