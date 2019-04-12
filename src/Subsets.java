import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, path, res, 0);
        return res;
    }

    public static void dfs(int[] nums, List<Integer> path, List<List<Integer>> res, int pointer) {
        res.add(new ArrayList<>(path));
        for (int i = pointer; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, path, res, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
}
