import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicatesII {
    public boolean containsNearbyDuplicateNaive(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length && j <= i + k; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    // O(n), O(n)
    public boolean containsNearbyDuplicateMap(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k)
                    return true;
            }
            map.put(nums[i], i); // update index for each number in nums
        }
        return false;
    }

    // O(n), O(k)
    public boolean containsNearbyDuplicateSet(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) { // if set.size() == k + 1
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
