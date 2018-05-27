/**
 * https://leetcode.com/problems/number-of-islands/description/
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p/>
 * Example 1:
 * <p/>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p/>
 * Output: 1
 * Example 2:
 * <p/>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p/>
 * Output: 3
 * <p/>
 * Created by deng on 2018/5/27.
 */
public class NumberofIslands {

    public static void main(String[] args) {
        char[][] a = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '1', '0'}};
        //char[][] a = {{'1', '0'}, {'0', '1'}};
        int res = numIslands(a);
        System.out.println(res);
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int res = 0;
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j, row, col);
                }
            }
        return res;
    }

    public static void dfs(char[][] grid, int x, int y, int row, int col) {
        if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == '0') return;
        grid[x][y] = '0';
        dfs(grid, x - 1, y, row, col);
        dfs(grid, x + 1, y, row, col);
        dfs(grid, x, y - 1, row, col);
        dfs(grid, x, y + 1, row, col);
    }
}
