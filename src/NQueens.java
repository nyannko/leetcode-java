import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        int row = 0;
        int[] path = new int[n];
        Arrays.fill(path, -1);
        List<List<String>> res = new ArrayList<>();
        dfs(n, path, row, res);
        return res;
    }

    public void dfs(int n, int[] path, int row, List res) {
        if (row == path.length) {
            List<String> s = new ArrayList<>();
            for (int i = 0; i < path.length; i++) {
                String r = "";
                for (int j = 0; j < n; j++) {
                    if (j == path[i]) {
                        r += "Q";
                    } else {
                        r += ".";
                    }
                }
                s.add(r);
            }
            res.add(s);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(path, row, i)) {
                path[row] = i;
                dfs(n, path, row + 1, res);
            }
        }
    }

    public boolean isValid(int[] path, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (path[i] == col) {
                return false;
            }
            if (Math.abs(i - row) == Math.abs(path[i] - col)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens n = new NQueens();
        System.out.println(n.solveNQueens(4));
    }
}
