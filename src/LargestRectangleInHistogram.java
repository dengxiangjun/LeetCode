/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * For example,
 * Given heights = [2,1,5,6,2,3],
 * return 10.
 * Created by admin on 2018/3/14.
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] a = {2,1,5,6,2,3};
        int res = largestRectangleArea(a);
        System.out.println(res);
    }

    /**
     * O(n^2)超时
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int maxArea = heights[i], minHeight = heights[i];
            for (int j = i + 1; j < heights.length; j++) {
                minHeight = Math.min(minHeight,heights[j]);
                maxArea = Math.max(maxArea,minHeight * (j - i + 1));
            }
            res = Math.max(maxArea,res);
        }
        return res;
    }
}
