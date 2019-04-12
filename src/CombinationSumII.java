import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, path, res, target, 0);
        return res;
    }

    public void dfs(int[] candidates, List<Integer> path, List<List<Integer>> res, int target, int pointer) {
        if (target < 0) return;
        else if (target == 0) res.add(new ArrayList<>(path));
        else {
            for (int i = pointer; i < candidates.length; i++) {
                if (i > pointer && candidates[i] == candidates[i - 1]) continue;
                path.add(candidates[i]);
                dfs(candidates, path, res, target - candidates[i], i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
