import java.util.List;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * <p>
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * Created by deng on 2018/1/23.
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        String s = "()(())";
        int result = longestValidParentheses(s);
        System.out.println(result);
    }

    public static int longestValidParentheses(String s) {
        s = ')' + s;
        int max = 0, len = s.length();
        char[] ch = s.toCharArray();
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            if (ch[i] == ')') {
                if (ch[i - 1 - dp[i - 1]] == '(') dp[i] = dp[i - 1] + 2;
                dp[i] += dp[i - dp[i]];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
