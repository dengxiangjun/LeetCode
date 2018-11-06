/**
 * https://leetcode.com/problems/island-perimeter/description/
 * You are given a map in form of a two-dimensional integer grid where 1 represents
 * land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally).
 * The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 * <p>
 * Example:
 * <p>
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * <p>
 * Answer: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 *
 * @author dengxiangjun@jd.com
 * @date 2018/10/9 15:35
 **/
public class IslandPerimeter {

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int res = islandPerimeter(grid);
        System.out.println(res);
    }

//    public static int islandPerimeter(int[][] grid) {
//        int[] res = new int[1];
//        int[][] visit = new int[grid.length][grid[0].length];
//        dfs(grid, res, 0, 0, visit);
//        return res[0];
//    }
//
//    public static void dfs(int[][] grid, int[] res, int x, int y, int[][] visit) {
//        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visit[x][y] == 1) return;
//        if (grid[x][y] == 1) {
//            if (x == 0 || grid[x - 1][y] == 0) res[0]++;
//            if (x == grid.length - 1 || grid[x + 1][y] == 0) res[0]++;
//            if (y == 0 || grid[x][y - 1] == 0) res[0]++;
//            if (y == grid[0].length - 1 || grid[x][y + 1] == 0) res[0]++;
//        }
////        grid[x][y] = 2;
//        visit[x][y] = 1;
//        dfs(grid, res, x - 1, y, visit);
//        dfs(grid, res, x + 1, y, visit);
//        dfs(grid, res, x, y - 1, visit);
//        dfs(grid, res, x, y + 1, visit);
//    }

    public static int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) res += 4;
                //res -=
            }
        return res;
    }
}
