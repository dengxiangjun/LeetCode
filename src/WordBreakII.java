import java.util.*;

/**
 * https://leetcode.com/problems/word-break-ii/description/
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * You may assume the dictionary does not contain duplicate words.
 * <p>
 * Return all such possible sentences.
 * <p>
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * <p>
 * A solution is ["cats and dog", "cat sand dog"].
 * <p>
 * UPDATE (2017/1/4):
 * The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
 * Created by deng on 2018/4/18.
 */
public class WordBreakII {

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        List<String> res = wordBreak(s, wordDict);
        System.out.println(res);
    }

//    /**
//     * 暴力搜索，TLE
//     * @param s
//     * @param wordDict
//     * @return
//     */
//    public static List<String> wordBreak(String s, List<String> wordDict) {
//        List<String> res = new ArrayList<String>();
//        dfs(s, wordDict, 0, new ArrayList<String>(), res);
//        return res;
//    }
//
//    public static void dfs(String s, List<String> wordDict, int start, List<String> item, List<String> res) {
//        if (start == s.length()) {
//            res.add(String.join(" ", new ArrayList<String>(item)));
//            return;
//        }
//        for (int i = start + 1; i <= s.length(); i++) {
//            String sub = s.substring(start, i);
//            if (wordDict.contains(sub)) {
//                item.add(sub);
//                dfs(s, wordDict, i, item, res);
//                item.remove(item.size() - 1);
//            }
//        }
//    }

    /**
     * 记忆化搜索
     * @param s
     * @param wordDict
     * @return
     */
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<String>();
        Set<String> set = new HashSet<String>();
        for (String word : wordDict) set.add(word);
        Map<String, List<String>> used = new HashMap<String, List<String>>();//记忆搜索过的子串
        res = dfs(s, set, used);
        return res;
    }

    public static List<String> dfs(String s, Set<String> set, Map<String, List<String>> used) {
        if (used.containsKey(s)) return used.get(s);
        if (s.length() == 0) return null;
        List<String> res = new ArrayList<String>();
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            List<String> partRes = null;
            if (set.contains(sub)) {
                partRes = dfs(s.substring(i), set, used);
                if (partRes == null) res.add(sub);
                else {
                    for (String str : partRes) {
                        res.add(sub + " " + str);
                    }
                }
            }
        }
        used.put(s, res);
        return res;
    }
}
