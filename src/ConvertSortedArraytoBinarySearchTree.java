import util.TreeNode;

public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode dfs = dfs(nums, 0, nums.length - 1);
        return dfs;
    }

    public TreeNode dfs(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = (l + r) >>> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, l, mid - 1);
        root.right = dfs(nums, mid + 1, r);
        return root;
    }
}
