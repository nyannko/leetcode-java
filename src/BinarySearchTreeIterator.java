import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {

    private Stack<TreeNode> stack;
    private TreeNode root;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        this.root = root;
        while (this.root != null) {
            stack.add(root);
            this.root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if (stack != null || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            if (root == null) {
                TreeNode nextNode = stack.pop();
                root = nextNode.right;
                return nextNode.val;
            }
        }
        return 0;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        if (stack.empty() && root == null) {
            return false;
        }
        return true;
    }
}