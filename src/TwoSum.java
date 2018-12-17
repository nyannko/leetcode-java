import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (map.containsKey(j)) {
                return new int[] {map.get(j), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum t = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(t.twoSum(nums, target));

    }
}
