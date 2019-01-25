import java.util.ArrayList;
import java.util.List;

import util.Node;

public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    public void dfs(Node root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        for (Node node : root.children) {
            dfs(node, res);
        }
    }
}
