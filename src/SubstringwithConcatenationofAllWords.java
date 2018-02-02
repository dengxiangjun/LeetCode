import java.util.*;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * <p/>
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * <p/>
 * You should return the indices: [0,9].
 * (order does not matter).
 * Created by deng on 2018/1/27.
 */
public class SubstringwithConcatenationofAllWords {
    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"foo", "bar", "the"};
        List<Integer> result = findSubstring(s, words);
        System.out.println(result);
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> rst = new ArrayList<Integer>();
        if (words.length == 0) return rst;
        int wordLen = words[0].length();
        int subLen = wordLen * words.length;
        HashMap<String, Integer> countMap = new HashMap<String, Integer>();
        for (String word : words) {
            if (countMap.containsKey(word)) countMap.put(word, countMap.get(word) + 1);
            else countMap.put(word, 1);
        }
        for (int i = 0; i < s.length() - subLen + 1; i++) {
            HashMap<String, Integer> copyMap = (HashMap<String, Integer>) countMap.clone();
            for (int j = 0; j < words.length; j++) {
                String word = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                if (copyMap.containsKey(word)) {
                    if (copyMap.get(word) == 1) copyMap.remove(word);
                    else copyMap.put(word, copyMap.get(word) - 1);
                } else break;
            }
            if (copyMap.isEmpty()) rst.add(i);
        }
        return rst;
    }
}
