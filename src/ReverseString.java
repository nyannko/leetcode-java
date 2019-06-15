public class ReverseString {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            char tmp = s[l];
            s[l++] = s[r];
            s[r--] = tmp;
        }
    }

    public void reverseString1(char[] s) {
        dfs(s, 0, s.length - 1);
    }

    public void dfs(char[] s, int l, int r) {
        if (l >= r) return;
        char tmp = s[l];
        s[r] = s[l];
        s[l] = tmp;
        dfs(s, l + 1, r - 1);
    }
}
