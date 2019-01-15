import java.util.Arrays;

public class MaximumGap {
    public int maximumGap(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i] - nums[i - 1];
            if (val > res) {
                res = val;
            }
        }
        return res;
    }
}
