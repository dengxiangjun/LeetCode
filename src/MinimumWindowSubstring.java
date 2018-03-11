/**
 * https://leetcode.com/problems/minimum-window-substring/description/
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * <p>
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * <p>
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * Created by deng on 2018/3/9.
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String res = minWindow("ABBCD", "ABC");
        System.out.println(res);
    }

    public static String minWindow(String s, String t) {
        String res = "";
        char[] tTable = new char[256];
        char[] sTable = new char[256];
        for (int i = 0; i < t.length(); i++) tTable[t.charAt(i)]++;
        int left = findNextCharInT(0, s, tTable), right = left, matchCnt = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (sTable[ch] < tTable[ch]) {//
                matchCnt++;
            }
            sTable[ch]++;
            while (left < s.length() && matchCnt == t.length()) {//left与right之间找到一个匹配的串，需要移动左指针
                if (res.isEmpty() || res.length() > right - left + 1) res = s.substring(left, right + 1);//更新res
                char leftChar = s.charAt(left);
                if (sTable[leftChar] == tTable[leftChar]) matchCnt--;
                sTable[leftChar]--;
                left = findNextCharInT(left + 1, s, tTable);
            }
            right = findNextCharInT(right + 1, s, tTable);
        }
        return res;
    }

    /**
     * 查找下一个S中包含T中字符的位置
     * @param from
     * @param s
     * @param tTable
     * @return
     */
    public static int findNextCharInT(int from, String s, char[] tTable) {
        int i = from;
        while (i < s.length()) {
            if (tTable[s.charAt(i)] > 0) return i;
            i++;
        }
        return i;
    }
}
