/**
 * https://leetcode.com/problems/regular-expression-matching/description/
 * Implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
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
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        String s = "ab", p = ".*c";
        boolean result = isMatch(s, p);
        System.out.println(result);
    }

    /**
     * 回溯
     * @param s
     * @param p
     * @return
     */
//    public static boolean isMatch(String s, String p) {
//        if (s == null || p == null) return false;
//        else return isMatch(s, p, 0, 0);
//    }

//    public static boolean isMatch(String s, String p, int i, int j) {
//        if (i == s.length() && j == p.length()) return true;
//        if (i != s.length() && j == p.length()) return false;
//        if (i == s.length() && j != p.length()) {
//            //只有pattern剩下的部分类似a*b*c*的形式，才匹配成功
//            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
//                return isMatch(s, p, i, j + 2);
//            }
//            return false;
//        }
//        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
//            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')
//                return isMatch(s, p, i, j + 2) || isMatch(s, p, i + 1, j + 2) || isMatch(s, p, i + 1, j);
//            else return isMatch(s, p, i, j + 2);
//        }
//        if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))
//            return isMatch(s, p, i + 1, j + 1);
//        return false;
//    }

    /**
     * dp
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        char[] c1 = s.toCharArray(), c2 = p.toCharArray();
        boolean[][] result = new boolean[m + 1][n + 1];
        result[0][0] = true;
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
               // if (c1[])
            }
        return result[m][n];
    }
}
