import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(candidates, path, res, target, 0);
        return res;
    }

    public static void dfs(int[] candidates, List<Integer> path, List<List<Integer>> res, int target, int pointer) {
        if (target < 0) return;
        else if (target == 0) res.add(new ArrayList<>(path));
        else {
            for (int i = pointer; i < candidates.length; i++) {
                path.add(candidates[i]);
                dfs(candidates, path, res, target - candidates[i], i);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        CombinationSum.combinationSum(candidates, 7);
    }
}
