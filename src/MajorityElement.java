import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
    // https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html
    public static int majorityElement2(int[] nums) {
        int major = 0, count = 0;
        for (int n : nums) {
            if (count == 0) {
                count++;
                major = n;
            } else if (major == n) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }

    public int majorityElement3(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
            if (map.get(n) > nums.length / 2) {
                return n;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MajorityElement m = new MajorityElement();
        m.majorityElement2(new int[]{5, 5, 0, 0, 0, 5, 0, 0, 5});
    }
}
