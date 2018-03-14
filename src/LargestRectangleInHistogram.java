import java.util.Stack;

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
        int[] a = {2, 1,2};
        int res = largestRectangleArea(a);
        System.out.println(res);
    }

//    /**
//     * O(n^2)超时
//     * @param heights
//     * @return
//     */
//    public static int largestRectangleArea(int[] heights) {
//        int res = 0;
//        for (int i = 0; i < heights.length; i++) {
//            int maxArea = heights[i], minHeight = heights[i];
//            for (int j = i + 1; j < heights.length; j++) {
//                minHeight = Math.min(minHeight,heights[j]);
//                maxArea = Math.max(maxArea,minHeight * (j - i + 1));
//            }
//            res = Math.max(maxArea,res);
//        }
//        return res;
//    }

    /**
     * 使用栈，O(n)解法
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        for (int i = 1; i <= heights.length;) {
            int height = i == heights.length ? 0 : heights[i];//在数组末尾构造一个高度为0的元素
            if (stack.isEmpty() || height >= heights[stack.peek()]) stack.push(i++);//栈存储不下降序列的下标
            else {
                while (!stack.isEmpty() && height < heights[stack.peek()]) {//若栈顶元素大于当前高度
                    int index = stack.pop();//出栈
                    int area = heights[index] *  (stack.empty() ? i : i - stack.peek() - 1);//计算高度
                    res = Math.max(res,area);//取最大值
                }
            }
        }
        return res;
    }
}
