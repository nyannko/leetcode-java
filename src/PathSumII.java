import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, path, res, sum);
        return res;
    }

    public void dfs(TreeNode root, List<Integer> path, List<List<Integer>> res, int sum) {
        if (root == null) return;
        path.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(path));
        }
        dfs(root.left, path, res, sum);
        dfs(root.right, path, res, sum);
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> allPath(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, path, res);
        return res;
    }

    public void dfs(TreeNode root, List<Integer> path, List<List<Integer>> res) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        dfs(root.left, path, res);
        dfs(root.right, path, res);
        System.out.println(path.get(path.size() - 1));
        path.remove(path.size() - 1);
    }


    // slow
    public void dfs1(TreeNode root, List<Integer> path, List<List<Integer>> res, int sum) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (root.val != sum) return;
            path.add(root.val);
            res.add(path);
            return;
        }
        path.add(root.val);
        dfs1(root.left, new ArrayList<>(path), res, sum - root.val);
        dfs1(root.right, new ArrayList<>(path), res, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.left = new TreeNode(4);
        a.left.right = new TreeNode(5);
        PathSumII p = new PathSumII();
        p.pathSum(a, 10);
    }

}
