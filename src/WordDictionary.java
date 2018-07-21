/**
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
 * Design a data structure that supports the following two operations:
 * <p>
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only
 * letters a-z or .. A . means it can represent any one letter.
 * <p>
 * Example:
 * <p>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */
public class WordDictionary {

    public static void main(String[] args) {
        String word = "a";
        WordDictionary obj = new WordDictionary();
        obj.addWord(word);
        System.out.println(obj.search(".a"));
    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode(' ');
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode[] children = root.children;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (children[ch - 'a'] == null) {
                children[ch - 'a'] = new TrieNode(ch);
            }
            if (i == word.length() - 1) children[ch - 'a'].isWord = true;
            children = children[ch - 'a'].children;
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    public static boolean dfs(TrieNode trieNode, String word, int index) {
        char ch = word.charAt(index);
        if (index == word.length() - 1){
            if (ch != '.') return trieNode.children[ch - 'a'] != null && trieNode.children[ch - 'a'].isWord;
            else {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (trieNode.children[c - 'a'] != null){
                        if (trieNode.children[c - 'a'].isWord) return true;
                    }
                }
                return false;
            }
        }

        if (ch != '.') return trieNode.children[ch - 'a'] != null
                && dfs(trieNode.children[ch - 'a'], word, index + 1);
        else {
            boolean subMatched = false;
            for (char c = 'a'; c <= 'z'; c++) {
                if (trieNode.children[c - 'a'] != null){
                    subMatched = subMatched || dfs(trieNode.children[c - 'a'], word, index + 1);
                }
            }
            return subMatched;
        }
    }

    private class TrieNode {
        private TrieNode[] children;
        private char val;
        private boolean isWord;

        public TrieNode(char val) {
            this.children = new TrieNode[26];
            this.val = val;
        }

        public TrieNode() {
        }
    }
}
