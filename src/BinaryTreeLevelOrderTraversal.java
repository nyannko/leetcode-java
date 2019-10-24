import util.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    // dfs
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, root, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) return;
        if (level >= res.size()) {
            res.add(new LinkedList<>());
            // res.add(0, new LinkedList<>());
        }
        dfs(res, root.left, level + 1);
        dfs(res, root.right, level + 1);
        res.get(level).add(root.val);
//        res.get(res.size() - 1 - level).add(root.val);
    }

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
