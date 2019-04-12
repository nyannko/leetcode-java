public class LongestCommonSequence {

    public static int lcs1(char[] A, char[] B, int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (A[m - 1] == B[n - 1]) {
            return 1 + lcs1(A, B, m - 1, n - 1);
        } else {
            return Math.max(lcs1(A, B, m - 1, n), lcs1(A, B, m, n - 1));
        }
    }

    public static int lcs(String A, String B, int i, int j) {
        if (i == 0 || j == 0) return 0;
        if (A.charAt(i - 1) == B.charAt(j - 1)) {
            return 1 + lcs(A, B, i - 1, j - 1);
        } else {
            return Math.max(lcs(A, B, i - 1, j), lcs(A, B, i, j - 1));
        }
    }

    public static int lcstring(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();
        int[][] L = new int[lenA + 1][lenB + 1];
        int result = 0;
        for (int i = 0; i <= lenA; i++) {
            for (int j = 0; j <= lenB; j++) {
                if (i == 0 || j == 0) {
                    L[i][j] = 0;
                } else if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    L[i][j] = 1 + L[i - 1][j - 1];
                    result = Math.max(result, L[i][j]);
                } else {
                    L[i][j] = 0;
                }
            }
        }
        return result;
    }

    // O(mn)
    public static int lcsdp(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();
        int[][] L = new int[lenA + 1][lenB + 1];
        for (int i = 0; i <= lenA; i++) {
            for (int j = 0; j <= lenB; j++) {
                if (i == 0 || j == 0) L[i][j] = 0;
                else if (A.charAt(i - 1) == B.charAt(j - 1)) L[i][j] = 1 + L[i - 1][j - 1];
                else L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[lenA][lenB];
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        System.out.println(lcs1(X, Y, X.length, Y.length));
        System.out.println(lcs("AGGTAB", "GXTXAYB", X.length, Y.length));

        System.out.println(lcsdp(s1, s2));
        System.out.println(lcstring("abcdxyz", "xyzabcd"));
        // lcs dp
    }
}
