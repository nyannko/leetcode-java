import java.util.Arrays;

class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '#';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    private static final int[][] dis = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static boolean[][] visited;

    // another boolean visited array with int direction array
    public int numIslands1(char[][] grid) {
        // check boundary
        if (grid == null || grid.length == 0) return 0;

        int count = 0;

        int row = grid.length;
        int col = grid[0].length;

        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs1(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs1(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] != '1') return;
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newX = i + dis[k][0];
            int newY = j + dis[k][1];
            dfs1(grid, newX, newY);
        }
    }

    public static void main(String[] args) {
        NumberOfIslands a = new NumberOfIslands();
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(a.numIslands(grid));
        System.out.println(Arrays.deepToString(grid));
    }

}