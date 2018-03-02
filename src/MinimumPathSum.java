/**
 * https://leetcode.com/problems/minimum-path-sum/description/
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example 1:
 * [[1,3,1],
 * [1,5,1],
 * [4,2,1]]
 * Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
 * <p>
 * Created by deng on 2018/3/2.
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] a = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int res = minPathSum(a);
        System.out.println(res);
    }

    public static int minPathSum(int[][] a) {
        int m = a.length, n = a[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = a[0][0];
        for (int i = 1; i < m; i++) dp[i][0] = dp[i - 1][0] + a[i][0];
        for (int i = 1; i < n; i++) dp[0][i] = dp[0][i - 1] + a[0][i];
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++) dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + a[i][j];
        return dp[m - 1][n - 1];
    }
}
