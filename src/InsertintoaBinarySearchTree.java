import util.TreeNode;

public class InsertintoaBinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root.val > val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                root.left = insertIntoBST2(root.left, val);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                root.right = insertIntoBST2(root.right, val);
            }
        }
        return root;
    }

    public TreeNode insertIntoBST3(TreeNode root, int val) {
        TreeNode node = new TreeNode(val),
                cur = root;
        while (cur != null) {
            if (cur.val > val) {
                if (cur.left != null) {
                    cur = cur.left;
                } else {
                    cur.left = node;
                    break;
                }
            } else {
                if (cur.right != null) {
                    cur = cur.right;
                } else {
                    cur.right = node;
                    break;
                }
            }
        }
        return (root != null) ? root : node;
    }
}
