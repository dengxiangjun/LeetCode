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
        List<Integer> list0 = new ArrayList<Integer>(),list1 = new ArrayList<Integer>(),
                list2 = new ArrayList<Integer>(),list3 = new ArrayList<Integer>();
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

    /**
     * dp
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        dp[0] = 0;
        return 0;
    }
}
