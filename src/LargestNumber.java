import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";

        String[] strs = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String str1 = s1 + s2;
                String str2 = s2 + s1;
                return str2.compareTo(str1);
            }
        };
        Arrays.sort(strs, c);
        if (strs[0].equals("0")) return "0";

        StringBuffer sb = new StringBuffer();
        for (String s: strs) {
            sb.append(s);
        }
        return sb.toString();
    }
}
