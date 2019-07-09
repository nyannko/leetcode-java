import java.util.Arrays;

public class MinimumPathSum {
    public static int minPathSumDFS(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;

        int[][] cache = new int[row][col];
        for (int[] r : cache) Arrays.fill(r, -1);

        // fill cache
        cache[0][0] = grid[0][0];
        dfs(row - 1, col - 1, grid, cache);

        return cache[row - 1][col - 1];
    }


    public static int dfs(int m, int n, int[][] grid, int[][] cache) {
        // reach to row or col, just return the max int to get row or col value
        if (m < 0 || n < 0) return Integer.MAX_VALUE;
        if (m == 0 && n == 0) return grid[m][n];
        if (cache[m][n] == -1) // if not recorded in cache
            cache[m][n] = grid[m][n] + Math.min(dfs(m - 1, n, grid, cache), dfs(m, n - 1, grid, cache));
        return cache[m][n];
    }

    public static int minPathSumDP(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int row = grid.length;
        int col = grid[0].length;

        // init cache
        int[][] cache = new int[row][col];
        cache[0][0] = grid[0][0];

        // fill first row
        for (int i = 1; i < col; i++) {
            cache[0][i] = cache[0][i - 1] + grid[0][i];
        }

        // fill first col
        for (int i = 1; i < row; i++) {
            cache[i][0] = cache[i - 1][0] + grid[i][0];
        }

        // fill intermediate grid
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                cache[i][j] = grid[i][j] + Math.min(cache[i - 1][j], cache[i][j - 1]);
            }
        }
        return cache[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(minPathSumDFS(grid));
        System.out.println(minPathSumDP(grid));
    }
}
