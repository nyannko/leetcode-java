import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }

        int mask = (diff & -diff);

        int[] res = new int[2];
        for (int num : nums) {
            if ((num & mask) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SingleNumberIII s = new SingleNumberIII();
        System.out.println(Integer.MIN_VALUE & Integer.MAX_VALUE);
        int[] res = s.singleNumber(new int[]{3, 3, Integer.MIN_VALUE, 1});
        System.out.println(Arrays.toString(res));
    }
}
