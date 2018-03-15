/**
 * https://leetcode.com/problems/maximal-rectangle/description/
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * <p/>
 * For example, given the following matrix:
 * <p/>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 6.
 * Created by deng on 2018/3/14.
 */
public class MaximalRectangle {

    public static void main(String[] args) {
        char[][] a = {{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
        int res = maximalRectangle(a);
        System.out.println(res);
    }

    public static int maximalRectangle(char[][] a) {
        if (a == null || a.length == 0) return 0;
        int[][] dp = new int[a.length][a[0].length];
        dp[0][0] = a[0][0] == 0 ? 0 : 1;

        for (int i = 1; i < a[0].length; i++) dp[0][i] = a[0][i - 1] == 0 ? dp[0][i - 1] : (dp[0][i - 1] + a[0][i - 1]);
        for (int i = 1; i < a.length; i++)  dp[i][0] = a[i - 1][0] == 0 ? dp[i - 1][0] : (dp[i - 1][0] + a[i - 1][0]);
        for (int i = 1; i < a.length; i++)
            for (int j = 1; j < a[0].length; j++) {
                if (a[i][j] == 0) dp[i][j] = 0;
                else {
                    if (a[i - 1][j] == 0) dp[i][j] = 0;
                }
            }
        return 0;
    }
}
