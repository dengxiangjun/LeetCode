/**
 * https://leetcode.com/problems/unique-paths/description/
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * <p>
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * <p>
 * Created by deng on 2018/3/2.
 */
public class UniquePaths {

    public static void main(String[] args) {
        int res = uniquePaths(23, 12);
        System.out.println(res);
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < n; i++) dp[0][i] = 1;

        for (int i = 1; i < m; i++)
            for (int j = 1; j <n; j++) dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        return dp[m-1][n-1];
    }

//    /**
//     * dfs，超时
//     * @param m
//     * @param n
//     * @return
//     */
//    public static int uniquePaths(int m, int n) {
//        int[] res = new int[1];
//        dfs(m, n, res);
//        return res[0];
//    }
//
//    public static void dfs(int m, int n, int[] res) {
//        if (m == 1 && n == 1) {
//            res[0] = res[0] + 1;
//            return;
//        }
//        if (m > 1) dfs(m - 1, n, res);
//        if (n > 1) dfs(m, n - 1, res);
//    }
}
