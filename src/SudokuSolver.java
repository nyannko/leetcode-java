import java.util.Arrays;

public class SudokuSolver {
    public static void solveSudoku(char[][] board) {
        solve(board);
    }

    public static boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') { // start filling the blank
                    for (char curr = '1'; curr <= '9'; curr++) {
                        board[i][j] = curr; // then fill it with '1' - '9'
                        if (isValid(board, i, j) && solve(board)) return true;
                        else board[i][j] = '.'; // turn back
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(char[][] board, int i, int j) {
        // same element in the same col
        for (int curX = 0; curX < board.length; curX++) {
            if (curX != i && board[curX][j] == board[i][j]) return false;
        }
        // same element in the same row
        for (int curY = 0; curY < board.length; curY++) {
            if (curY != j && board[i][curY] == board[i][j]) return false;
        }
        // same element in the same subgrid
        for (int curX = 3 * (i / 3); curX < 3 * (i / 3 + 1); curX++) {
            for (int curY = 3 * (j / 3); curY < 3 * (j / 3 + 1); curY++) {
                if (curX != i && curY != j && board[curX][curY] == board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] b = new char[][] {
                {'.','5','8','.','3','.','.','2','.'},
                {'4','.','2','.','.','.','9','.','5'},
                {'.','.','7','.','.','.','6','8','.'},
                {'2','9','.','.','5','4','.','7','.'},
                {'5','.','.','.','6','2','.','.','.'},
                {'.','.','3','8','1','.','2','5','.'},
                {'1','.','9','.','.','3','.','6','4'},
                {'8','6','5','4','9','.','1','3','.'},
                {'.','7','.','.','.','6','.','.','.'}};
        solveSudoku(b);
        for (char[] s : b) {
            System.out.println(Arrays.toString(s));
        }
    }
}
