import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0, n = s.length();
        int[] index = new int[128];
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        int[] index = new int[128];
        int res = 0, i = 0, j = 0;
        while (i < s.length()) {
            if (j < s.length() && index[s.charAt(j)] == 0) {
                index[s.charAt(j)]++;
                j++;
                res = Math.max(res, j - i);
            } else {
                index[s.charAt(i)]--;
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        LongestSubstringWithoutRepeatingCharacter l = new LongestSubstringWithoutRepeatingCharacter();
        System.out.println(l.lengthOfLongestSubstring2(str));
    }
}
