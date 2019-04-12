import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, path, res);
        return res;
    }

    public void dfs(int[] nums, List<Integer> path, List<List<Integer>> res) {
        // the base case
        if (nums.length == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }

        // find if index is in the tmp list
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, path, res);
            path.remove(path.size() - 1); // remove index
        }
    }
}
