import util.TreeNode;

public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;

        flatten(left);
        flatten(right);

        TreeNode cur = root;
        root.right = left;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = right;
    }
}
