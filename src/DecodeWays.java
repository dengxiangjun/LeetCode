/**
 * https://leetcode.com/problems/decode-ways/description/
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * <p>
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * <p>
 * The number of ways decoding "12" is 2.
 * <p>
 * <p>
 * Created by deng on 2018/3/16.
 */
public class DecodeWays {

    public static void main(String[] args) {
        int res = numDecodings("110");
        System.out.println(res);
    }

    public static int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == 0 ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            int oneChar = s.charAt(i - 1) - '0';
            int twoChar = Integer.valueOf(s.substring(i - 2, i));
            if (oneChar >= 1 && oneChar <= 9) dp[i] += dp[i - 1];
            if (twoChar >= 10 && twoChar <= 26) dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }
}
