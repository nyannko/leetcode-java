public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();
        for (int i = 0; i < h - n + 1; i++) {
            int j = i;
            int m = 0;
            while (m < n && haystack.charAt(j) == needle.charAt(m)) {
                j++;
                m++;
            }
            if (m == n) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementstrStr i = new ImplementstrStr();
        System.out.println(i.strStr("hello", "ll"));
    }
}
