import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, path, res, 0);
        return res;
    }

    public void dfs(int[] nums, List<Integer> path, List<List<Integer>> res, int pointer) {
        res.add(new ArrayList<>(path));
        for (int i = pointer; i < nums.length; i++) {
            if (i > pointer && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            dfs(nums, path, res, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
