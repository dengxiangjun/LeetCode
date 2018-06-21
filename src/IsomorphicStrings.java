import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/isomorphic-strings/description/
 * Given two strings s and t, determine if they are isomorphic.
 * <p/>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p/>
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 * <p/>
 * Example 1:
 * <p/>
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 * <p/>
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 * <p/>
 * Input: s = "paper", t = "title"
 * Output: true
 * Example 4:
 * <p/>
 * Input: s = "ab", t = "aa"
 * Output: false
 * Created by deng on 2018/5/30.
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "ab", t = "aa";
        boolean res = isIsomorphic(s, t);
        System.out.println(res);
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.isEmpty() && t.isEmpty()) return true;
        if (s.length() != t.length()) return false;
        int[] a = new int[256], b = new int[256];
        Arrays.fill(a, -1);
        Arrays.fill(b, -1);
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            if (a[c1] == -1 && b[c2] == -1) {
                a[c1] = c2;
                b[c2] = c1;
            } else {
                if (a[c1] != c2 || b[c2] != c1) return false;
            }
        }
        return true;
    }
}
