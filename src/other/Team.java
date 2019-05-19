package other;

import java.util.Arrays;
import java.util.Scanner;

public class Team {
    //old scanner way..
    //    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String line = in.nextLine();
//        String[] size= line.split(",");
//        int row = Integer.valueOf(size[0]);
//        int col = Integer.valueOf(size[1]);
//        int[][] board = new int[row][col];
//        for (int i = 0; i < row; i++) {
//            line = in.nextLine();
//            String[] digits = line.split(",");
//            for (int j = 0; j < col; j++) {
//                board[i][j] = Integer.valueOf(digits[j]);
//            }
//        }
//        System.out.println(Arrays.deepToString(board));
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("[,\n]"); // use comma and newline delimiter
        int row = in.nextInt(), col = in.nextInt();
        char[][] board = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = in.next().charAt(0);
            }
        }
        in.close();
        System.out.println("Input row: " + row + " col: " + col);
        System.out.println(Arrays.deepToString(board));
        numberOfTeam(board);
    }

    public static void numberOfTeam(char[][] board) {
        if (board == null || board.length == 0) return;
        int count = 0;
        int depth = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '1') {
                    depth = Math.max(depth, dfs(board, i, j));
                    count++;
                }
            }
        }
        System.out.println("The number of the team: " + count);
        System.out.println("The number of people in the largest team: " + depth);
        System.out.println(count + "," + depth);
    }

    public static int dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '0') return 0;
        board[i][j] = '0';
        return 1 + dfs(board, i + 1, j)
                + dfs(board, i - 1, j)
                + dfs(board, i, j + 1)
                + dfs(board, i, j - 1)
                + dfs(board, i + 1, j + 1)
                + dfs(board, i + 1, j - 1)
                + dfs(board, i - 1, j + 1)
                + dfs(board, i - 1, j - 1);
    }
    //getString case, 6, 8
//10,10
//0,0,0,0,0,0,0,0,0,0
//0,0,0,1,1,0,1,0,0,0
//0,1,0,0,0,0,0,1,0,1
//1,0,0,0,0,0,0,0,1,1
//0,0,0,1,1,1,0,0,0,1
//0,0,0,0,0,0,1,0,1,1
//0,1,1,0,0,0,0,0,0,0
//0,0,0,1,0,1,0,0,0,0
//0,0,1,0,0,1,0,0,0,0
//0,1,0,0,0,0,0,0,0,0
}
