/**
 * https://leetcode.com/problems/length-of-last-word/description/
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p/>
 * If the last word does not exist, return 0.
 * <p/>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p/>
 * Example:
 * <p/>
 * Input: "Hello World"
 * Output: 5
 * Created by deng on 2018/2/28.
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        String s = "H";
        int res = lengthOfLastWord(s);
        System.out.println(res);
    }

    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int i = s.length() - 1;
        while (i>=0 && s.charAt(i) == ' ') i--;
        int j = i;
        while (i >=0 && s.charAt(i) != ' ') {
           i--;
        }
        return j - i;
    }
}
