package other;

import java.util.Scanner;
import java.util.Arrays;

public class Team1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("[\\s*,\n]");
        int row = sc.nextInt();
        int col = sc.nextInt();

        char[][] board = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (sc.hasNext()) {
                    board[i][j] = sc.next().charAt(0);
                }
            }
        }

        System.out.println(Arrays.deepToString(board));
        calTeams(board, row, col);
    }

    public static void calTeams(char[][] board, int row, int col) {
        if (board == null || board.length == 0) return;
        int depth = 0;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '1') {
                    depth = Math.max(depth, dfs(board, i, j));
                    count++;
                }
            }
        }
        System.out.println(depth + " " + count);
    }

    public static int dfs(char[][] board, int i, int j) {
       if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '0') return 0;
       board[i][j] = '0';
       return 1 + dfs(board, i + 1, j)
               + dfs(board, i - 1, j)
               + dfs(board, i, j - 1)
               + dfs(board, i, j + 1)
               + dfs(board, i + 1, j + 1)
               + dfs(board, i + 1, j - 1)
               + dfs(board, i - 1, j + 1)
               + dfs(board, i - 1, j - 1);
    }
}
