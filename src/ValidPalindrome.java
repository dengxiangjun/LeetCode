/**
 * https://leetcode.com/problems/valid-palindrome/description/
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * <p>
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * <p>
 * For the purpose of this problem, we define empty string as valid palindrome.
 * Created by deng on 2018/3/31.
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "0P";
        boolean res = isPalindrome(s);
        System.out.println(res);
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char left = s.charAt(i), right = s.charAt(j);
            if (!isAlphanumeric(left)) {
                i++;
                continue;
            } else if (!isAlphanumeric(right)) {
                j--;
                continue;
            } else if (Character.toLowerCase(left) == Character.toLowerCase(right)) {
                i++;
                j--;
            } else return false;
        }
        return true;
    }

    public static boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}
