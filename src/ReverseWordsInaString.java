/**
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 * Given an input string, reverse the string word by word.
 * <p/>
 * Example:
 * <p/>
 * Input: "the sky is blue",
 * Output: "blue is sky the".
 * Note:
 * <p/>
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 * Follow up: For C programmers, try to solve it in-place in O(1) space.
 * Created by deng on 2018/5/22.
 */
public class ReverseWordsInaString {

    public static void main(String[] args) {
        String s = "    ";
        String res = reverseWords(s);
        System.out.println(res);
    }

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        if (" ".equals(s)) return "";
        char[] ch = s.toCharArray();
        int start = 0, end = ch.length - 1;
        while (start < end && (ch[start] == ' ' || ch[end] == ' ')) {
            if (ch[start] == ' ') start++;
            if (ch[end] == ' ') end--;
        }
        for (int i = start, j = end; i < j; i++, j--) {
            char tmp = ch[i];
            ch[i] = ch[j];
            ch[j] = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = start, j = start; i <= end && j <= end; ) {
            while (j <= end && ch[j] != ' ') j++;
            int l = i, r = j - 1;
            while (l < r) {
                char tmp = ch[l];
                ch[l] = ch[r];
                ch[r] = tmp;
                l++;
                r--;
            }
            sb.append(String.valueOf(ch, i, j - i)).append(" ");
            while (j < end && ch[j] == ' ') j++;
            i = j;
        }
        if (sb.toString().equals("")) return sb.toString();
        else
            return sb.substring(0, sb.length() - 1);
    }
}
