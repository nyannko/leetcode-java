public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs(int[] nums, int l, int r) {
        if (l > r) return null;
        int max = max(nums, l, r);
        TreeNode root = new TreeNode(nums[max]);
        root.left = dfs(nums, l, max - 1);
        root.right = dfs(nums, max + 1, r);
        return root;
    }

    public int max(int[] nums, int l, int r) {
        int max = r;
        for (int i = l; i < r; i++) {
            if (nums[i] > nums[max]) max = i;
        }
        return max;
    }
}
