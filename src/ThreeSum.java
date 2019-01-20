import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // sort the list
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // skip the same i value
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // start binary search
            int target = -nums[i];
            int l = i + 1,
                    r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) l++; // skip the same l value
                    while (l < r && nums[r] == nums[r + 1]) r--; // skip the same r value
                } else if (nums[l] + nums[r] < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(t.threeSum(nums));
    }
}
