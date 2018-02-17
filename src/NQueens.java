import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/description/
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p/>
 * <p/>
 * <p/>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p/>
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * <p/>
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * <p/>
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p/>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * Created by deng on 2018/2/13.
 */
public class NQueens {

    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        char[][] ch = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) ch[i][j] = '.';
        dfs(ch, res, 0);
        return res;
    }

    public static void dfs(char[][] ch, List<List<String>> res, int col) {
        if (col >= ch.length) {
            res.add(construct(ch));
            return;
        }

        for (int i = 0; i < ch.length; i++) {
            if (isValid(ch, i, col)) {
                ch[i][col] = 'Q';
                dfs(ch, res, col + 1);
                ch[i][col] = '.';
            }
        }
    }

    public static List<String> construct(char[][] ch) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < ch.length; i++) {
            String s = new String(ch[i]);
            list.add(s);
        }
        return list;
    }


    public static boolean isValid(char[][] ch, int x, int y) {
        for(int i = 0; i < ch.length; i++) {
            for(int j = 0; j < y; j++) {
                if(ch[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }
        return true;
    }
}
