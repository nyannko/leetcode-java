import util.TreeNode;

import java.util.*;

class BinaryTree {

    private TreeNode root;


    public int getRoot() {
        return this.root.val;
    }

    public void insert(int val) {
        root = insertDFS(root, val);
    }

    private TreeNode insertDFS(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insertDFS(root.left, val);
        else root.right = insertDFS(root.right, val);
        return root;
    }

    public boolean search(int val) {
        return searchDFS(root, val);
    }

    private boolean searchDFS(TreeNode root, int val) {
        if (root == null) return false;

        if (val == root.val) return true;
        else if (val < root.val) {
            return searchDFS(root.left, val);
        } else {
            return searchDFS(root.right, val);
        }
    }

    public List<List<Integer>> getTreeNodes() {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subRes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                subRes.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(subRes);
        }
        return res;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int[] arr = {4, 2, 6, 1, 3, 5, 7};
        for (int i : arr) {
            bt.insert(i);
        }
        System.out.println(bt.getTreeNodes());
    }
}
