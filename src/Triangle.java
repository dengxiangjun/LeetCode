import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/triangle/description/
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p>
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * <p>
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 * Created by admin on 2018/3/26.
 */
public class Triangle {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> list0 = new ArrayList<Integer>(), list1 = new ArrayList<Integer>(),
                list2 = new ArrayList<Integer>(), list3 = new ArrayList<Integer>();
        list0.add(2);
        list1.add(3);
        list1.add(4);

        list2.add(6);
        list2.add(5);
        list2.add(7);

        list3.add(4);
        list3.add(1);
        list3.add(8);
        list3.add(3);
        triangle.add(list0);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        int res = minimumTotal(triangle);
        System.out.println(res);
    }

//    /**
//     * 递归
//     * Time Limit Exceeded
//     * @param triangle
//     * @return
//     */
//    public static int minimumTotal(List<List<Integer>> triangle) {
//        int[] min = new int[1];
//        min[0] = Integer.MAX_VALUE;
//        dfs(triangle, 0, 0, 0, min);
//        return min[0];
//    }
//
//    public static void dfs(List<List<Integer>> triangle, int row, int col, int sum, int[] min) {
//        if (col < 0) return;
//        if (row >= triangle.size()) {
//            min[0] = Math.min(sum, min[0]);
//            return;
//        }else if (col >= triangle.get(row).size()) return;
//        sum += triangle.get(row).get(col);
//        dfs(triangle,row + 1,col,sum,min);
//        dfs(triangle,row + 1,col + 1,sum,min);
//    }

//    /**
//     * dp O(n*n) extra space
//     * 自顶向下
//     * @param triangle
//     * @return
//     */
//    public static int minimumTotal(List<List<Integer>> triangle) {
//        if (triangle == null || triangle.size() == 0) return 0;
//        int[][] dp = new int[triangle.size()][triangle.size()];
//        dp[0][0] = triangle.get(0).get(0);
//        if (triangle.size() == 1) return dp[0][0];
//        int min = Integer.MAX_VALUE;
//        for (int i = 1; i < triangle.size(); i++) {
//            for (int j = 0; j < triangle.get(i).size(); j++) {
//                if (j == 0) dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
//                else if (j == triangle.get(i).size() - 1) dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
//                else dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
//                if (i == triangle.size() - 1) min = Math.min(min, dp[i][j]);
//            }
//        }
//        return min;
//    }

    /**
     * dp O(n) extra space
     * 自底向上
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int[]dp = new int[triangle.size() + 1];
        dp[0] = triangle.get(0).get(0);
        for (int i = triangle.size() - 1; i >=0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
               dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
