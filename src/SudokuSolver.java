import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/sudoku-solver/description/
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p/>
 * Empty cells are indicated by the character '.'.
 * <p/>
 * You may assume that there will be only one unique solution.
 * <p/>
 * <p/>
 * A sudoku puzzle...
 * <p/>
 * <p/>
 * ...and its solution numbers marked in red.
 * <p/>
 * Created by deng on 2018/2/4.
 */
public class SudokuSolver {

    public static void main(String[] args) {
        char[][] a = {{'.', '8', '7', '6', '5', '4', '3', '2', '1'}, {'2', '.', '.', '.', '.', '.', '.', '.', '.'}, {'3', '.', '.', '.', '.', '.', '.', '.', '.'}
                , {'4', '.', '.', '.', '.', '.', '.', '.', '.'}, {'6', '.', '.', '.', '.', '.', '.', '.', '.'}, {'6', '.', '.', '.', '.', '.', '.', '.', '.'}
                , {'7', '.', '.', '.', '.', '.', '.', '.', '.'}, {'8', '.', '.', '.', '.', '.', '.', '.', '.'}, {'9', '.', '.', '.', '.', '.', '.', '.', '.'}};
        solveSudoku(a);
    }

    public static void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board.length != board[0].length) return;
        solve(board);
    }

    public static boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != '.' && c == board[row][i]) return false;
            if (board[i][col] != '.' && c == board[i][col]) return false;
        }

        for (int i = 0; i < 9; i += 3)
            for (int j = 0; j < 9; j += 3) {
                HashSet<Character> squre = new HashSet<Character>();
                for (int k = 0; k < 9; k++) {
                    if (board[i + k / 3][j + k % 3] != '.') {
                        int num = board[i + k / 3][j + k % 3] - '0';
                        if (num < 1 || num > 9 || !squre.add(board[i + k / 3][j + k % 3])) {
                            return false;
                        }
                    }
                }
            }
        return true;
    }
}
