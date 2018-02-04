import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/valid-sudoku/description/
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * <p/>
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * <p/>
 * <p/>
 * A partially filled sudoku which is valid.
 * <p/>
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * Created by deng on 2018/2/4.
 */
public class ValidSudoku {
    public static void main(String[] args) {
        char[][] a = {{'.', '8', '7', '6', '5', '4', '3', '2', '1'}, {'2', '.', '.', '.', '.', '.', '.', '.', '.'}, {'3', '.', '.', '.', '.', '.', '.', '.', '.'}
                , {'4', '.', '.', '.', '.', '.', '.', '.', '.'}, {'6', '.', '.', '.', '.', '.', '.', '.', '.'}, {'6', '.', '.', '.', '.', '.', '.', '.', '.'}
                , {'7', '.', '.', '.', '.', '.', '.', '.', '.'}, {'8', '.', '.', '.', '.', '.', '.', '.', '.'}, {'9', '.', '.', '.', '.', '.', '.', '.', '.'}};
        boolean result = isValidSudoku(a);
        System.out.println(result);
    }

    public static boolean isValidSudoku(char[][] a) {
        int len = a.length, total = len * len;
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<Character>(), col = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                if (a[i][j] != '.') {
                    int num = a[i][j] - '0';
                    if (num < 1 || num > 9 || !row.add(a[i][j])) return false;
                }
                if (a[j][i] != '.') {
                    int num = a[j][i] - '0';
                    if (num < 1 || num > 9 || !col.add(a[j][i]))
                        return false;
                }
            }
        }

        for (int i = 0; i < 9; i += 3)
            for (int j = 0; j < 9; j += 3) {
                HashSet<Character> squre = new HashSet<Character>();
                for (int k = 0; k < 9; k++) {
                    if (a[i + k / 3][j + k % 3] != '.') {
                        int num = a[i + k / 3][j + k % 3] - '0';
                        if (num < 1 || num > 9 || !squre.add(a[i + k / 3][j + k % 3])) {
                            return false;
                        }
                    }
                }
            }
        return true;
    }
}
