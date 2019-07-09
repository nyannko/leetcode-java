import java.util.ArrayList;
import java.util.List;

public class FindPath {
    public static List<List<Integer>> findPath(int[][] grid) {
        // boundary check
        if (grid == null || grid.length == 0 || grid[0].length == 0) return null;

        int m = grid.length;
        int n = grid[0].length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(m - 1, n - 1, grid, path, res);
        return res;
    }

    public static void dfs(int m, int n, int[][] grid, List<Integer> path, List<List<Integer>> res) {
        if (m < 0 || n < 0) return;
        path.add(grid[m][n]);
        if (m == 0 && n == 0)
            res.add(new ArrayList<>(path));
        dfs(m - 1, n, grid, path, res);
        dfs(m, n - 1, grid, path, res);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(findPath(grid));
        // [[9, 6, 3, 2, 1], [9, 6, 5, 2, 1], [9, 6, 5, 4, 1], [9, 8, 5, 2, 1], [9, 8, 5, 4, 1], [9, 8, 7, 4, 1]]
    }
}
