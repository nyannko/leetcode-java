public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') { // start filling the blank
                    for (char curr = '1'; curr <= '9'; curr++) {
                        if (isValid(board, i, j)) { // check if the current board is valid

                            board[i][j] = curr; // then fill it with '1' - '9'
                        }
                        if (solve(board)) return true;
                        else board[i][j] = '.'; // turn back
                    }
                }
            }
        }
        return false;
    }

    public boolean isValid(char[][] board, int i, int j) {
        for (int currX = 0; currX < 9; currX++) {
            if (currX != i && board[i][j] == board[currX][j]) return false;
        }
        for (int currY = 0; currY < 9; currY++) {
            if (currY != j && board[i][j] == board[i][currY]) return false;
        }
        for (int currX = 0; currX < 9; currX++) {
            for (int currY = 0; currY < 9; currY++) {
                if (currX != i && currY != j && board[i][j] == board[currX][currY]) return false;
            }
        }
        return true;
    }
}
