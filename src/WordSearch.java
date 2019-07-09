public class WordSearch {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(wordSearch(board, ""));
        System.out.println(wordSearch(board, "ABCCED"));
        System.out.println(wordSearchTable(board, "SEE"));

    }

    public static boolean wordSearch(char[][] board, String word) {
        // boundary check
        if (board == null || board.length == 0 || board[0].length == 0) return false;

        char[] words = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, board, words, 0))
                    return true;
            }
        }
        return false;
    }

    public static boolean dfs(int i, int j, char[][] board, char[] words, int l) {
        if (l == words.length) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != words[l]) return false;
        board[i][j] ^= 256; // change to a different char
        boolean res = dfs(i + 1, j, board, words, l + 1) ||
                dfs(i - 1, j, board, words, l + 1) ||
                dfs(i, j + 1, board, words, l + 1) ||
                dfs(i, j - 1, board, words, l + 1);
        board[i][j] ^= 256; // change back
        return res;
    }

    // method 2: look for table..
    public static boolean wordSearchTable(char[][] board, String word) {
        // boundary check
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        if (word == null || word.length() == 0) return false;

        char[] words = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs1(board, words, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private static final int[][] dis = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static boolean dfs1(char[][] board, char[] words, int i, int j, int index) {
        if (index == words.length) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != words[index]) return false;
        board[i][j] ^= 256;
        for (int k = 0; k < 4; k++) {
            int newI = i + dis[k][0];
            int newJ = j + dis[k][1];
            if (dfs1(board, words, newI, newJ, index + 1)) return true;
        }
        board[i][j] ^= 256;
        return false;
    }
}
