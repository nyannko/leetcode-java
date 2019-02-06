import util.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val &&
                isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(10);
        p.left = new TreeNode(11);
        p.right = new TreeNode(12);
        TreeNode q = new TreeNode(10);
        q.left = new TreeNode(11);
        q.right = new TreeNode(12);
        SameTree s = new SameTree();
        System.out.println(s.isSameTree(p, q));
    }
}
