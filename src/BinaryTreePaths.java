import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }

    public void dfs(TreeNode root, String path, List<String> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
        }
        path += root.val + "->";
        dfs(root.left, path, res);
        dfs(root.right, path, res);
    }
}
