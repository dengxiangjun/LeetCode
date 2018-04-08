/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/description/
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * <p>
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * <p>
 * <p>
 * Created by admin on 2018/4/8.
 */
public class PalindromePartitioningII {

    public static void main(String[] args) {
        String s = "aaabc";
        int res = minCut(s);
        System.out.println(res);
    }

    public static int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] cuts = new int[len];
        boolean[][] isPalindrome = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || isPalindrome[j + 1][i - 1])) {
                    isPalindrome[j][i] = true;//表示字符j到字符i是一个回文串
                    min = j == 0 ? 0 : Math.min(min, cuts[j - 1] + 1);
                }
            }
            cuts[i] = min;
        }
        return cuts[len - 1];
    }
}
