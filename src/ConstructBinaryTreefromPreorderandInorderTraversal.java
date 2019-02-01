public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int pl, int il, int ir) {
        if (pl > preorder.length - 1 || il > ir) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pl]);
        int inRootPos = 0; // Index of current root in inorder
        for (int i = il; i <= ir; i++) {
            if (inorder[i] == root.val) {
                inRootPos = i;
            }
        }
        root.left = helper(preorder, inorder, pl + 1, il, inRootPos - 1);
        root.right = helper(preorder, inorder, pl + inRootPos - il + 1, inRootPos + 1, ir);
        return root;
    }
}
