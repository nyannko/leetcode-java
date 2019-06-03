import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int increase(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    res[i] = Math.max(res[i], res[j] + 1);
                    max = res[i];
                }
            }
        }
//        System.out.println(Arrays.toString(res));
//        return findMax(res);
        return max;
    }

    public static int findMax(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] res = {10, 15, 20, 11, 9, 101};
        int[] res2 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(increase(res2));
    }
}
