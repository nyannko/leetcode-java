public class JumpGame {
    // from the last index
    public boolean canJump(int[] nums) {
        int leftMost = nums.length - 1;
        int i = leftMost - 1;
        while (i >= 0) {
            if (i + nums[i] >= leftMost) {
                leftMost = i;
            }
            i--;
        }
        return leftMost == 0;
    }

    public boolean canJump1(int[] nums) {
        int reach = 0;
        int i = 0;
        while (i <= reach && reach < nums.length - 1) {
            int distance = i + nums[i];
            reach = Math.max(reach, distance);
            i++;
        }
        return reach >= nums.length - 1;
    }

    public int jump(int[] nums) {
        int cur, last, result;
        cur = last = result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > last) {
                last = cur;
                result++;
            }
            cur = Math.max(cur, i + nums[i]);
        }
        return result;
    }
}
