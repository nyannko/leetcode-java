import java.util.*;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        // add nums1 to set
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) set1.add(i);

        // create result set, check if nums2 is in set1
        Set<Integer> set = new HashSet<>();
        for (int i : nums2) {
            if (set1.contains(i)) set.add(i);
        }

        // create result int[]
        int[] res = new int[set.size()];
        int j = 0;
        for (int i : set) {
            res[j++] = i;
        }
        return res;
    }
}
