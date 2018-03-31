import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder-ii/description/
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * For example,
 * <p>
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * Return
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * Note:
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * UPDATE (2017/1/20):
 * The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
 * Created by deng on 2018/3/31.
 */
public class WordLadderII {

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> list = new ArrayList<String>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        List<List<String>> res = ladderLength(beginWord, endWord, list);
        System.out.println(res);
    }

    public static List<List<String>> ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<String>(wordList);
        if (!set.contains(endWord)) return null;
        Queue<String> queue = new LinkedList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(beginWord, 1);
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            String s = queue.poll();
            int curLevel = map.get(s);
            for (int i = 0; i < s.length(); i++) {
                char[] arr = s.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    arr[i] = j;
                    String tmp = String.valueOf(arr);
                    if (set.contains(tmp)) {
                        map.put(tmp, curLevel + 1);
                        if (tmp.equals(endWord)) return null;
                        set.remove(tmp);
                        queue.offer(tmp);
                    }
                }
            }
        }
        return null;
    }
}
