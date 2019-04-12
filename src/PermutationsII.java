import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, path, res, used);
        return res;
    }

    public static void dfs(int[] nums, List<Integer> path, List<List<Integer>> res, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] ) continue;
            used[i] = true;
            path.add(nums[i]);
            dfs(nums, path, res, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(PermutationsII.permuteUnique(new int[]{1, 1, 2}));
    }
}
