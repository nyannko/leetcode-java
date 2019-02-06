import util.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int il, int ir, int pl) {
        if (pl < 0 || il < ir)
            return null;

        TreeNode root = new TreeNode(postorder[pl]);
        int inRootPos = il;
        for (int i = il; i >= ir; i--) {
            if (inorder[i] == root.val) {
                inRootPos = i;
                break;
            }
        }
        root.right = buildTree(inorder, postorder, il, inRootPos + 1, pl - 1);
        root.left = buildTree(inorder, postorder, inRootPos - 1, ir, pl - (il - inRootPos) - 1);
        return root;
    }
}
