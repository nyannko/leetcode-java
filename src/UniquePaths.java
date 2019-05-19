public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        return dfs(m - 1, n - 1);
    }

    public static int dfs(int m, int n) {
        if (m == 0 || n == 0) return 1;
        return dfs(m - 1, n) + dfs(m, n - 1);
    }

    public static int uniquePathsDP(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        uniquePaths(3, 2);
    }
}
