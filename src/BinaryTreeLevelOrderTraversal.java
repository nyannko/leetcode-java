import util.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder1(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
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
            res.add(subRes);
        }
        return res;
    }

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
