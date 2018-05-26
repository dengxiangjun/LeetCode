/**
 * https://leetcode.com/problems/compare-version-numbers/description/
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
 * <p/>
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three",
 * it is the fifth second-level revision of the second first-level revision.
 * <p/>
 * Example 1:
 * <p/>
 * Input: version1 = "0.1", version2 = "1.1"
 * Output: -1
 * Example 2:
 * <p/>
 * Input: version1 = "1.0.1", version2 = "1"
 * Output: 1
 * Example 3:
 * <p/>
 * Input: version1 = "7.5.2.4", version2 = "7.5.3"
 * Output: -1
 * Created by deng on 2018/5/24.
 */
public class CompareVersionNumbers {

    public static void main(String[] args) {
        String s1 = "7.5.2.4", s2 = "7.5.3";
        int res = compareVersion(s1, s2);
        System.out.println(res);
    }

    public static int compareVersion(String version1, String version2) {
        if (version1 == null || version1.isEmpty()) return -1;
        if (version2 == null || version2.isEmpty()) return 1;
        String[] s1 = version1.split("\\."), s2 = version2.split("\\.");
        int len1 = s1.length > s2.length ? s1.length : s2.length;
        for (int i = 0; i < len1; i++) {
            int a = i < s1.length ? Integer.valueOf(s1[i]) : 0;
            int b = i < s2.length ? Integer.valueOf(s2[i]) : 0;
            if (a > b) return 1;
            else if (a < b) return -1;
        }
        return 0;
    }
}
