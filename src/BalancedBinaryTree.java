import util.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        int val = getDepth(root);
        if (val == -1) {
            return false;
        }
        return true;
    }

    public int getDepth(TreeNode root) {
        if (root == null) return 0;
        int ll = getDepth(root.left);
        int lr = getDepth(root.right);
        int abs = Math.abs(ll - lr);
        if (ll == -1 || lr == -1 || abs > 1) {
            return -1;
        }
        return Math.max(ll, lr) + 1;
    }


    public boolean isBalanced2(TreeNode root) {
        if (root == null) return true;
        int ll = getDepth(root.left);
        int lr = getDepth(root.right);
        return Math.abs(ll - lr) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int getDepth2(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        // tree 1
//        TreeNode a = new TreeNode(3);
//        a.left = new TreeNode(9);
//        a.right = new TreeNode(20);
//        a.right.left = new TreeNode(15);
//        a.right.right = new TreeNode(7);
        // tree 2
        TreeNode a = new TreeNode(0);
        TreeNode left = a;
        TreeNode right = a;
        for (int i = 1; i < 3; i++) {
            left.left = new TreeNode(i);
            left = left.left;
        }
//        a.left.right = new TreeNode(3);
//        for (int i = 1; i < 2; i++) {
//            right.right = new TreeNode(i);
//            right = right.right;
//        }

        BalancedBinaryTree b = new BalancedBinaryTree();
        System.out.println(b.isBalanced(a)); // if it's normal, return tree's height, else return -1
    }
}
