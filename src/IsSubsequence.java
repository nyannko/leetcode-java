public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int start = 0;
        for (char c : s.toCharArray()) {
            start = t.indexOf(c, start);
            if (start++ < 0) {
                return false;
            }
        }
        return true;
    }
}
