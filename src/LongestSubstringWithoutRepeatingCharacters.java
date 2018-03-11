/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Created by admin on 2018/3/11.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        int res = lengthOfLongestSubstring("au");
        System.out.println(res);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        int res = 1;
        int[] hash = new int[256];
        int left = 0, right = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (hash[ch] == 0) {
                hash[ch] = 1;
                right++;
            }else {
                res = Math.max(res, right - left);
                while (left < s.length() && s.charAt(left) != ch) {
                    hash[s.charAt(left)] = 0;
                    left++;
                }
                hash[s.charAt(left++)] = 0;
            }
        }
        return Math.max(res, right - left);
    }
}
