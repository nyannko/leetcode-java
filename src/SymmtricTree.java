public class SymmtricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return dfs(root.left, root.right);
        }
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val) {
            return dfs(left.left, right.right) && dfs(left.right, right.left);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(10);
        p.left = new TreeNode(11);
        p.right = new TreeNode(144);
        SymmtricTree s = new SymmtricTree();
        System.out.println(s.isSymmetric(p));
    }
}
