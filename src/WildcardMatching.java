/**
 * https://leetcode.com/problems/wildcard-matching/description/
 * Implement wildcard pattern matching with support for '?' and '*'.
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 * Created by deng on 2018/1/19.
 */
public class WildcardMatching {
    public static void main(String[] args) {
        String s = "ab", p = "?*";
        boolean result = isMatch(s, p);
        System.out.println(result);
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        char[] sc = s.toCharArray(), pc = p.toCharArray();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (pc[i - 1] == '*') dp[0][i] = dp[0][i - 1];
        }

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (sc[i - 1] == pc[j - 1] || pc[j - 1] == '?') dp[i][j] = dp[i - 1][j - 1];
                else if (pc[j - 1] == '*') dp[i][j] = dp[i][j - 1] || dp[i - 1][j - 1] || dp[i - 1][j];
                else dp[i][j] = false;
            }
        return dp[m][n];
    }
}
