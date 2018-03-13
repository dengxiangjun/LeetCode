/**
 * https://leetcode.com/problems/word-search/description/
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * For example,
 * Given board =
 * <p>
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * Created by admin on 2018/3/12.
 */
public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {{'C','A','A'}, {'A','A','A'}, {'B','C','D'}};
        boolean res = exist(board, "AAB");
        System.out.println(res);
    }

    public static boolean exist(char[][] board, String word) {
        if ((board == null && word == null) || (board.length == 0 && word.isEmpty())) return true;
        if (board.length == 0 || word.isEmpty()) return false;
        char[] wordArr = word.toCharArray();
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == wordArr[0] && dfs(board, wordArr, used, i, j, 0)) return true;
            }
        return false;
    }

    public static boolean dfs(char[][] board, char[] word, boolean[][] used, int x, int y, int cnt) {
        if (cnt == word.length) return true;
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) return false;
        if (used[x][y] || board[x][y] != word[cnt]) return false;
        used[x][y] = true;
        boolean exists = dfs(board, word, used, x - 1, y, cnt + 1)//上
                || dfs(board, word, used, x + 1, y, cnt + 1)//下
                || dfs(board, word, used, x, y - 1, cnt + 1)//左
                || dfs(board, word, used, x, y + 1, cnt + 1);//右
        used[x][y] = false;
        return exists;
    }
}
