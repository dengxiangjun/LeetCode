/**
 * https://leetcode.com/problems/minimum-window-substring/description/
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * <p>
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * <p>
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * Created by deng on 2018/3/9.
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String res = minWindow("ADOBECODEBANC","ABC");
        System.out.println(res);
    }

    public static String minWindow(String s, String t) {
        return "";
    }
}
