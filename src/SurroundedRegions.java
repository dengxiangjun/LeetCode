/**
 * https://leetcode.com/problems/surrounded-regions/description/
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * <p>
 * Created by admin on 2018/3/31.
 */
public class SurroundedRegions {

    public static void main(String[] args) {
        char[][] a = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solve(a);
        System.out.println();
    }

    public static void solve(char[][] a) {
        if (a == null || a.length == 0 || a[0].length == 0) return;
        int m = a.length - 1, n = a[0].length - 1;
        for (int i = 0; i <= m; i++) {
            if (a[i][0] == 'O')
                dfs(a, i, 0);
            if (a[i][n] == 'O')
                dfs(a, i, n);
        }

        for (int i = 0; i <= n; i++) {
            if (a[0][i] == 'O')
                dfs(a, 0, i);
            if (a[m][i] == 'O')
                dfs(a, m, i);
        }

        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++) {
                if (a[i][j] == 'O') a[i][j] = 'X';
                else if (a[i][j] == '1') a[i][j] = 'O';
            }
    }

    public static void dfs(char[][] a, int row, int col) {
        if (row < 0 || row >= a.length || col < 0 || col >= a[0].length) return;

        if (a[row][col] == 'O') {
            a[row][col] = '1';
            dfs(a, row + 1, col);
            dfs(a, row - 1, col);
            dfs(a, row, col + 1);
            dfs(a, row, col - 1);
        }
    }
}
