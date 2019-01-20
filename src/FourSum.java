import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> FourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // sort the list
        Arrays.sort(nums);
        // line 11, 12, 13, 15, 17, 22 are different with 3sum.
        for (int j = 0; j < nums.length - 3; j++) {
            if (j > 0 && nums[j] == nums[j - 1]) continue;
            for (int i = j + 1; i < nums.length - 2; i++) {
                // skip the same i value
                if (i > j + 1 && nums[i] == nums[i - 1]) continue;
                // start binary search
                int tar = target - nums[i] - nums[j];
                int l = i + 1,
                        r = nums.length - 1;
                while (l < r) {
                    if (nums[l] + nums[r] == tar) {
                        res.add(Arrays.asList(nums[j], nums[i], nums[l], nums[r]));
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) l++; // skip the same l value
                        while (l < r && nums[r] == nums[r + 1]) r--; // skip the same r value
                    } else if (nums[l] + nums[r] < tar) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
