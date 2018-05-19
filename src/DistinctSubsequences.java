/**
 * https://leetcode.com/problems/distinct-subsequences/description/
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * <p>
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * <p>
 * Return 3.
 * Created by admin on 2018/3/24.
 */
public class DistinctSubsequences {

//    public static void main(String[] args) {
//
//    }

    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < n; i++) dp[0][i] = 0;
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) != t.charAt(j - 1)) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                //如果S[i]==T[j]，那么dp[i][j] = dp[i-1][j-1] + dp[i-1][j]。
                // 意思是：如果当前S[i]==T[j]，那么当前这个字母即可以保留也可以抛弃，
                // 所以变换方法等于保留这个字母的变换方法加上不用这个字母的变换方法。
                //如果S[i]!=T[i]，那么dp[i][j] = dp[i-1][j]，意思是如果当前字符不等，那么就只能抛弃当前这个字符。
            }
        return dp[m][n];
    }
}
