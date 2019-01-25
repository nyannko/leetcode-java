import java.util.ArrayList;
import java.util.List;

import util.Node;

public class NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    public void dfs(Node root, List<Integer> res) {
        if (root == null) return;
        for (Node node : root.children) {
            dfs(node, res);
        }
        res.add(root.val);
    }
}
