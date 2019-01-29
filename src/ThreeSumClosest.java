import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int cloest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
           if (i > 0 && nums[i] == nums[i - 1]) {
               continue;
           }
           int l = i + 1,
                   r = nums.length - 1;
           while (l < r) {
                int value = nums[i] + nums[l] + nums[r];
                if (Math.abs(value - target) < Math.abs(cloest - target)) {
                    cloest = value;
                }
                if (value == target) {
                    return value;
                } else if (value < target) {
                    l++;
                } else {
                    r--;
                }
           }
        }
        return cloest;
    }
}
