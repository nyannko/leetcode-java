import util.TreeNode;

public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int res) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 10 * res + root.val;
        res = 10 * res + root.val;
        return dfs(root.left, res) + dfs(root.right, res);
    }
}
