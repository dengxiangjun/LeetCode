/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p/>
 * Example:
 * <p/>
 * Input: "babad"
 * <p/>
 * Output: "bab"
 * <p/>
 * Note: "aba" is also a valid answer.
 * <p/>
 * <p/>
 * Example:
 * <p/>
 * Input: "cbbd"
 * <p/>
 * Output: "bb"
 * Created by deng on 2018/1/23.
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "abcda";
        String result = longestPalindrome(s);
        System.out.println(result);
    }
    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length == 1) return s;
        int max = 0;
        String res = null;
        for (int i = 0; i < length; i++) {
            int low = i, high = i;
            while (low >= 0 && high < s.length()) {
                if (s.charAt(low) != s.charAt(high)) break;
                else if (s.charAt(low) == s.charAt(high) && (high - low + 1) > max) {
                    max = high - low + 1;
                    res = s.substring(low, high + 1);
                }
                low--;
                high++;
            }
            low = i;
            high = i + 1;
            while (low >= 0 && high < s.length()) {
                if (s.charAt(low) != s.charAt(high)) break;
                else if (s.charAt(low) == s.charAt(high) && (high - low + 1) > max) {
                    max = high - low + 1;
                    res = s.substring(low, high + 1);
                }
                low--;
                high++;
            }
        }
        return res;
    }
}
