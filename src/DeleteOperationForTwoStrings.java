/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/description/
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.
 * <p/>
 * Example 1:
 * Input: "sea", "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 * Note:
 * The length of given words won't exceed 500.
 * Characters in given words can only be lower-case letters.
 * Created by deng on 2018/3/9.
 */
public class DeleteOperationForTwoStrings {

    public static void main(String[] args) {
        int res = minDistance("sea", "eat");
        System.out.println(res);
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m == 0) return n;
        if (n == 0) return m;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];//相等，
                else dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - 1]) + 1;
            }
        return dp[m][n];
    }
}
