/**
 * https://leetcode.com/problems/n-queens-ii/description/
 * Follow up for N-Queens problem.
 * <p/>
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 */
public class NQueensII {
    public static int count = 0;

    public static void main(String[] args) {
        int res = totalNQueens(4);
        System.out.println(res);
    }

    public static int totalNQueens(int n) {
        char[][] ch = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) ch[i][j] = '.';
        count = 0;
        dfs(ch, 0);
        return count;
    }

    public static void dfs(char[][] ch, int col) {
        if (col >= ch.length) {
            count++;
        }

        for (int i = 0; i < ch.length; i++) {
            if (isValid(ch, i, col)) {
                ch[i][col] = 'Q';
                dfs(ch, col + 1);
                ch[i][col] = '.';
            }
        }
    }

    public static boolean isValid(char[][] ch, int x, int y) {
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < y; j++) {
                if (ch[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }
        return true;
    }
}
