import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    List<List<String>> result = new ArrayList<List<String>>();

    public List<List<String>> partition(String s) {
        dfs(s, new ArrayList<String>());
        return result;
    }

    public void dfs(String s, List<String> cur) {
        if(s.length() == 0) {
            result.add(cur);
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if(isPal(sub)) {
                List<String> newList = new ArrayList<String>(cur);
                newList.add(sub);
                dfs(s.substring(i, s.length()), newList);
            }
            else {
                continue;
            }
        }

    }

    public boolean isPal(String str) {
        int l = 0, r = str.length() - 1;
        while (l <= r) {
            if (str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        PalindromePartitioning p = new PalindromePartitioning();
        p.partition(s);
    }


}
