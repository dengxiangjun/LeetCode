/**
 * https://leetcode.com/problems/unique-paths-ii/description/
 * Follow up for "Unique Paths":
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * <p>
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * <p>
 * Note: m and n will be at most 100.
 * Created by deng on 2018/3/2.
 */
public class UniquePathsII {

    public static void main(String[] args) {
        int[][] a = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int res = uniquePathsWithObstacles(a);
        System.out.println(res);
    }

    public static int uniquePathsWithObstacles(int[][] a) {
        int m = a.length, n = a[0].length;
        int[][] dp = new int[m][n];
        if (a[0][0] == 1) return 0;
        dp[0][0] = 1;
        for (int i = 1; i < m && a[i][0] == 0; i++) dp[i][0] = 1;
        for (int i = 1; i < n && a[0][i] == 0; i++) dp[0][i] = 1;

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++) if (a[i][j] == 0) dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        return dp[m - 1][n - 1];
    }
}
