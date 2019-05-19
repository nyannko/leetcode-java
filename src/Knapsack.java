import java.util.Arrays;
import java.util.List;

public class Knapsack {
    private static int bestValue1(List<Integer> w, List<Integer> v, int index, int c) {
        if (index < 0 || c <= 0) return 0;
        int res = bestValue1(w, v, index - 1, c);
        if (c >= w.get(index))
            res = Math.max(res, v.get(index) + bestValue1(w, v, index - 1, c - w.get(index)));
        return res;
    }

    public static int knapsackRecursion(List<Integer> w, List<Integer> v, int c) {
        int n = w.size();
        return bestValue1(w, v, n - 1, c);
    }

    public static int knapsackMemo(List<Integer> w, List<Integer> v, int c) {
        int n = w.size();
        int[][] memo = new int[n][c + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return bestValue2(w, v, n - 1, c, memo);
    }

    private static int bestValue2(List<Integer> w, List<Integer> v, int index, int c, int[][] memo) {
        if (index < 0 || c <= 0) return 0;
        if (memo[index][c] != -1) return memo[index][c];
        int res = bestValue1(w, v, index - 1, c);
        if (c >= w.get(index))
            res = Math.max(res, v.get(index) + bestValue1(w, v, index - 1, c - w.get(index)));
        memo[index][c] = res;
        return res;
    }

    public static int knapsackDP(List<Integer> w, List<Integer> v, int c) {
        if (w.size() != v.size()) return 0; // items number in w and v should be same
        int n = w.size();
        int[][] dp = new int[n][c + 1];
        // initialize table with -1
        for (int[] row : dp) Arrays.fill(row, -1);

        // fill the first row
        for (int j = 0; j < n; j++) {
            dp[0][j] = (j >= w.get(0) ? v.get(0) : 0);
        }

        // fill the remaining values
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < c + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= w.get(i)) {
                    dp[i][j] = Math.max(dp[i][j], v.get(i) + dp[i - 1][j - w.get(i)]);
                }
            }
        }
        return dp[n - 1][c];
    }

    // use two rows time: O(n * c), space: O(2 * c)
    public static int knapsackDPSaveSpace(List<Integer> w, List<Integer> v, int c) {
        if (w.size() != v.size()) return 0; // items number in w and v should be same
        int n = w.size();
        int[][] dp = new int[2][c + 1];
        // initialize table with -1
        for (int[] row : dp) Arrays.fill(row, -1);

        // fill the first row
        for (int j = 0; j < n; j++) {
            dp[0][j] = (j >= w.get(0) ? v.get(0) : 0);
        }

        // fill the remaining values
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < c + 1; j++) {
                dp[i % 2][j] = dp[(i - 1) % 2][j];
                if (j >= w.get(i)) {
                    dp[i % 2][j] = Math.max(dp[i % 2][j], v.get(i) + dp[(i - 1) % 2][j - w.get(i)]);
                }
            }
        }
        return dp[(n - 1) % 2][c];
    }

    // use one row, update from right to left space: O(c)
    public static int knapsackDPSaveSpace1(List<Integer> w, List<Integer> v, int c) {
        if (w.size() != v.size()) return 0; // items number in w and v should be same
        int n = w.size();
        int[] dp = new int[c + 1];
        // initialize table with -1
        Arrays.fill(dp, -1);

        // fill the first row
        for (int j = 0; j < n; j++) {
            dp[j] = (j >= w.get(0) ? v.get(0) : 0);
        }

        // fill the remaining values
        for (int i = 1; i < n; i++) {
            for (int j = c; j >= w.get(i); j--) {
                dp[j] = Math.max(dp[j], v.get(i) + dp[j - w.get(i)]);
            }
        }
        return dp[c];
    }

    public static void main(String[] args) {
        List<Integer> w = Arrays.asList(1, 2, 3);
        List<Integer> v = Arrays.asList(6, 10, 12);
        int c = 5;
        System.out.println(knapsackDP(w, v, c));
        System.out.println(knapsackRecursion(w, v, c));
        System.out.println(knapsackMemo(w, v, c));
        System.out.println(knapsackDPSaveSpace(w, v, c));
        System.out.println(knapsackDPSaveSpace1(w, v, c));
    }
}
