/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 * Implement a trie with insert, search, and startsWith methods.
 * <p>
 * Example:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 * <p>
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("abc");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        trie.search("app");
        System.out.println(trie.search("app"));
        System.out.println(trie.search("a"));
    }

    private class TrieNode {
        private char val;
        private TrieNode[] children;
        public boolean isWord;

        public TrieNode() {
        }

        public TrieNode(char val) {
            this.val = val;
            this.children = new TrieNode[26];
        }
    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode(' ');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
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
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode[] children = root.children;
        TrieNode trieNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (children[ch - 'a'] == null) return false;
            trieNode = children[ch - 'a'];
            children = trieNode.children;
        }
        return trieNode.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode[] children = root.children;
        TrieNode trieNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (children[ch - 'a'] == null) return false;
            trieNode = children[ch - 'a'];
            children = trieNode.children;
        }
        return true;
    }

/**
 * 自己丑陋的解法
 */
//    private List<Trie> tries;
//    private char ch;
//    private boolean isEnd;
//
//
//    /**
//     * Initialize your data structure here.
//     */
//    public Trie() {
//        tries = new ArrayList<>();
//    }
//
//    /**
//     * Inserts a word into the trie.
//     */
//    public void insert(String word) {
//        List<Trie> cur = tries;
//        for (int i = 0; i < word.length(); i++) {
//            Trie trie = new Trie();
//            trie.ch = word.charAt(i);
//            if (!cur.contains(trie)) {
//                cur.add(trie);
//                cur = trie.tries;
//                if (i == word.length() - 1) trie.isEnd = true;
//            } else {
//                if (i == word.length() - 1) cur.get(cur.indexOf(trie)).isEnd = true;
//                cur = cur.get(cur.indexOf(trie)).tries;
//            }
//        }
//    }
//
//    /**
//     * Returns if the word is in the trie.
//     */
//    public boolean search(String word) {
//        List<Trie> cur = tries;
//        Trie curTrie = null;
//        for (int i = 0; i < word.length(); i++) {
//            Trie trie = new Trie();
//            trie.ch = word.charAt(i);
//            int index = cur.indexOf(trie);
//            if (index < 0) return false;
//            curTrie = cur.get(index);
//            cur = cur.get(index).tries;
//        }
//        return curTrie != null && curTrie.isEnd;
//    }
//
//    /**
//     * Returns if there is any word in the trie that starts with the given prefix.
//     */
//    public boolean startsWith(String prefix) {
//        List<Trie> cur = tries;
//        for (int i = 0; i < prefix.length(); i++) {
//            Trie trie = new Trie();
//            trie.ch = prefix.charAt(i);
//            int index = cur.indexOf(trie);
//            if (index < 0) return false;
//            cur = cur.get(index).tries;
//        }
//        return true;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Trie trie = (Trie) o;
//        return ch == trie.ch;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(ch);
//    }
}
