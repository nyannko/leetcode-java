import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(path, res, n, k, 1);
        return res;
    }

    public void dfs(List<Integer> path, List<List<Integer>> res, int n, int k, int pointer) {
        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = pointer; i <= n; i++) {
            path.add(i);
            dfs(path, res, n, k - 1, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
