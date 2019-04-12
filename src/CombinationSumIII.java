import java.util.*;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(k, n, path, res, 1);
        return res;
    }

    public void dfs(int k, int n, List<Integer> path, List<List<Integer>> res, int pointer) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(path));
        } else {
            for (int i = pointer; i < 10; i++) {
                path.add(i);
                dfs(k - 1, n - i, path, res, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
