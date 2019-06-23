import java.util.*;

public class ContainsDuplicatesIII {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            final Long floor = set.floor((long) nums[i] + t);
            final Long ceil = set.ceiling((long) nums[i] - t);

            if ((floor != null && floor >= (long) nums[i])
                    || (ceil != null && ceil <= (long) nums[i])) {
                return true;
            }

            set.add((long) nums[i]);
            if (set.size() == k + 1) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        HashSet<Long> set = new HashSet<>(Arrays.asList(0L, 2147483647L));
        containsNearbyAlmostDuplicate(new int[]{0, 2147483647}, 1, 2147483647);
    }
}
