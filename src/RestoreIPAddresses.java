import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        restoreIP(s, result, 0, "", 0);
        return result;
    }

    public void restoreIP(String s, List<String> solutions, int idx, String restored, int count) {
        if (count > 4) return;
        if (count == 4 && idx == s.length()) solutions.add(restored);

        for (int i = 1; i < 4; i++) {
            if (idx + i > s.length()) break;
            String sub = s.substring(idx, idx + i);
            if ((sub.startsWith("0") && sub.length() > 1) || (i == 3 && Integer.parseInt(sub) >= 256)) continue;
            restoreIP(s, solutions, idx + i, restored + sub + (count == 3 ? "" : "."), count + 1);
        }
    }
}
