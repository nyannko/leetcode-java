import util.TreeNode;

import java.util.*;
import java.util.concurrent.Callable;

public class CountCompleteTreeNodes {
    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

//    public int countNodes2(TreeNode root) {
//        int res = 0;
//        if (root == null) return res;
//        res = res + 1;
//        res = res + countNodes(root.left);
//        res = res + countNodes(root.right);
//        res = 1 + countNodes(root.left) + countNodes(root.right);
//        return res;
//    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth) {
            return (int) (countNodes(root.right) + Math.pow(2, leftDepth));
        } else {
            return (int) (countNodes(root.left) + Math.pow(2, rightDepth));
        }
    }

    public int getDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + getDepth(root.left);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(0);
        a.left = new TreeNode(1);
        a.left.left = new TreeNode(1);
//        a.left.right = new TreeNode(1);
        a.right = new TreeNode(2);
        CountCompleteTreeNodes c = new CountCompleteTreeNodes();
        System.out.println(c.countNodes(a));
    }

}
