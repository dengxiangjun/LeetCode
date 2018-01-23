/**
 * Created by deng on 2018/1/20.
 */

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {};
        String result = longestCommonPrefix(strs);
        System.out.println(result);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int minLen = Integer.MAX_VALUE;
        for (String s : strs) minLen = Math.min(minLen, s.length());
        if (minLen == 0) return "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);
            int j = 1;
            for (;j<strs.length;j++){
                if (c != strs[j].charAt(i)) break;
            }
            if (j <strs.length) break;
            else sb.append(c);
        }
        return sb.toString();
    }
}
