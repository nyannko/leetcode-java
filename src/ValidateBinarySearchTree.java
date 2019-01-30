public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    public boolean dfs(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null) return true;
        if ((left != null && root.val <= left.val) || (right != null && root.val >= right.val)) return false;
        return dfs(root.left, left, root) && dfs(root.right, root, right);
    }
}
