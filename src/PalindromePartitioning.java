import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/description/
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * For example, given s = "aab",
 * Return
 * <p>
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * <p>
 * Created by admin on 2018/3/31.
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> res = partition(s);
        System.out.println(res);
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) return res;
        dfs(res, new ArrayList<String>(), s);
        return res;
    }

    public static void dfs(List<List<String>> res, List<String> item, String s) {
        if (s.length() == 0) {
            res.add(new ArrayList<String>(item));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1);
            if (isPalindrome(sub)) {
                item.add(sub);
                dfs(res, item, s.substring(i + 1));
                item.remove(item.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++)
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        return true;
    }
}
