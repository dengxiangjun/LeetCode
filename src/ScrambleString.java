/**
 * https://leetcode.com/problems/scramble-string/description/
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * <p>
 * Below is one possible representation of s1 = "great":
 * <p>
 * great
 * /    \
 * gr    eat
 * / \    /  \
 * g   r  e   at
 * / \
 * a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * <p>
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 * <p>
 * rgeat
 * /    \
 * rg    eat
 * / \    /  \
 * r   g  e   at
 * / \
 * a   t
 * We say that "rgeat" is a scrambled string of "great".
 * <p>
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 * <p>
 * rgtae
 * /    \
 * rg    tae
 * / \    /  \
 * <p>
 * r   g  ta  e
 * / \
 * t   a
 * We say that "rgtae" is a scrambled string of "great".
 * <p>
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * Created by admin on 2018/3/15.
 */
public class ScrambleString {

    public static void main(String[] args) {
        String s1 = "abc", s2 = "bca";
        boolean res = isScramble(s1, s2);
        System.out.println(res);
    }

    /**
     * 递归
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        int[] hash = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            hash[s1.charAt(i)]++;
            hash[s2.charAt(i)]--;
        }
        for (int i = 0; i < s1.length(); i++) if (hash[s1.charAt(i)] != 0) return false;

        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(s1.length() - i)) && isScramble(s1.substring(i), s2.substring(0,s1.length() - i)))
                return true;
        }
        return false;
    }
}
