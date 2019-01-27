import java.util.LinkedList;

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
    private LinkedList<TreeNode> stack;
    private TreeNode root;

    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();
        this.root = root;
        while (this.root != null) {
            stack.push(this.root);
            this.root = this.root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
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
        if (stack.isEmpty() && root == null) {
            return false;
        }
        return true;
    }
}