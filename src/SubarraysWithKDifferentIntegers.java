import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {

    // this is naive O(n^2), TLE...
    public int subarraysWithKDistinct(int[] A, int K) {
        int res = 0;
        int count= K;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                while (count >= 0 && j < A.length) {
                    if (!map.containsKey(A[j])) {
                        map.put(A[j], true);
                        count--;
                        // System.out.println(i + " " + j  + " "  + map + " " + A[j] + " " + count);
                    }
                    if (count == 0) res++;
                    j++;
                }
                count = K;
                map.clear();
                break;
            }
        }
        return res;
    }
}
