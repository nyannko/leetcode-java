import java.util.ArrayList;
import java.util.Arrays;

public class DungeonGame {
    public static int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] cache = new int[m + 1][n + 1];

        // fill the last row
        Arrays.fill(cache[m], Integer.MAX_VALUE);

        // fill the last col
        for (int i = 0; i <= m; i++) {
            cache[i][m] = Integer.MAX_VALUE;
        }

        cache[m][n - 1] = 1;
        cache[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int minHP = Math.min(cache[i + 1][j], cache[i][j + 1]) - dungeon[i][j];
                cache[i][j] = (minHP <= 0) ? 1 : minHP;
            }
        }
        return cache[0][0];
    }

    public static int find(int[][] dungeon) {
        // boundary check
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return -1;
        int[][] cache = new int[dungeon.length + 1][dungeon[0].length + 1];
        return dfs(0, 0, dungeon, cache);
    }

    public static int dfs(int m, int n, int[][] dungeon, int[][] cache) {
        if (m == dungeon.length - 1 && n > dungeon[0].length - 1) return 1;
        if (m > dungeon.length - 1 && n == dungeon[0].length - 1) return 1;
        if (m > dungeon.length - 1 || n > dungeon[0].length - 1) return 2147483647;
        if (cache[m][n] == 0) {
            int res = Math.min(dfs(m + 1, n, dungeon, cache), dfs(m, n + 1, dungeon, cache)) - dungeon[m][n];
            cache[m][n] = res <= 0 ? 1 : res;
            System.out.println("finding res: " + res);
        }
        return cache[m][n];
    }

    public static void main(String[] args) {
        int[][] board = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(find(board));
        calculateMinimumHP(board);
    }
}
