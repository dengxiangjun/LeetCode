/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * <p>
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * <p>
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * Created by deng on 2018/3/20.
 */
public class InterleavingString {

    public static void main(String[] args) {
        String s1 = "a", s2 = "", s3 = "a";
        boolean res = isInterleave(s1, s2, s3);
        System.out.println(res);
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) return false;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) dp[0][i] = true;
            else break;
        }
        for (int i = 1; i <= n; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1)) dp[i][0] = true;
            else break;
        }

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                dp[i][j] = (dp[i - 1][j] && s2.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] && s1.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        return dp[n][m];
    }

}
