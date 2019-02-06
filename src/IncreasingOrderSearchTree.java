import util.TreeNode;

public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        return dfs(root, null);
    }

    public TreeNode dfs(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        TreeNode res = dfs(root.left, root);
        root.left = null;
        root.right = dfs(root.right, tail);
        return res;
    }
}
