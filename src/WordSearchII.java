import java.util.*;

/**
 * https://leetcode.com/problems/word-search-ii/description/
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent"
 * cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 * <p>
 * Example:
 * <p>
 * Input:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * <p>
 * Output: ["eat","oath"]
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 */
public class WordSearchII {

    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
//        char[][] board = {{'a', 'a'}};
//        String[] words = {"aaa"};
        List<String> res = findWords(board, words);
        System.out.println(res);
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> wordsSet = new HashSet<>();

        for (String word : words) {
            wordsSet.add(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char ch = board[i][j];
                board[i][j] = '.';
                dfs(board, wordsSet, "" + ch, j, i, res);
                board[i][j] = ch;
            }
        }

        return res;
    }

    public static void dfs(char[][] board, Set<String> words, String s, int x, int y, List<String> res) {
        if (x < 0 || x >= board[0].length || y < 0 || y >= board.length) return;
        boolean sholudReturn = false;
        for (String word : words) if (word.startsWith(s)) sholudReturn = true;
        if (!sholudReturn) return;
        if (words.contains(s) && !res.contains(s)) res.add(s);
        if (x - 1 >= 0 && board[y][x - 1] != '.') {
            char left = board[y][x - 1];
            board[y][x - 1] = '.';
            dfs(board, words, s + left, x - 1, y, res);
            board[y][x - 1] = left;
        }

        if (x + 1 < board[0].length && board[y][x + 1] != '.') {
            char right = board[y][x + 1];
            board[y][x + 1] = '.';
            dfs(board, words, s + right, x + 1, y, res);
            board[y][x + 1] = right;
        }

        if (y - 1 >= 0 && board[y - 1][x] != '.') {
            char up = board[y - 1][x];
            board[y - 1][x] = '.';
            dfs(board, words, s + up, x, y - 1, res);
            board[y - 1][x] = up;
        }

        if (y + 1 < board.length && board[y + 1][x] != '.') {
            char down = board[y + 1][x];
            board[y + 1][x] = '.';
            dfs(board, words, s + down, x, y + 1, res);
            board[y + 1][x] = down;
        }
    }
}
