import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {

    // this is naive O(n^2), TLE...
    public static int subarraysWithKDistinct(int[] A, int K) {
        int res = 0;
        int count = K;
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

    public static int test(int[] A, int K) {
        int i = 0, res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int j = 0; j < A.length; ++j) {
            if (count.getOrDefault(A[j], 0) == 0) K--;
            count.put(A[j], count.getOrDefault(A[j], 0) + 1);
            while (K < 0) {
                count.put(A[i], count.get(A[i]) - 1);
                if (count.get(A[i]) == 0) K++;
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3};
        int K = 2;
        System.out.println(test(arr, K));
    }

}
