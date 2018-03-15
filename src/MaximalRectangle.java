import java.util.Stack;

/**
 * https://leetcode.com/problems/maximal-rectangle/description/
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * <p>
 * For example, given the following matrix:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 6.
 * Created by deng on 2018/3/14.
 */
public class MaximalRectangle {

    public static void main(String[] args) {
        char[][] a = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        int res = maximalRectangle(a);
        System.out.println(res);
    }

    /**
     * 转化成LargestRectangleInHistogram问题
     * @param a
     * @return
     */
    public static int maximalRectangle(char[][] a) {
        if (a == null || a.length == 0) return 0;
        int res = 0;
        int[] heights = new int[a[0].length];//该数组表示从第0行到当前行的直方图高度
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == '0') heights[j] = 0;
                else heights[j]++;
            }
            res = Math.max(res,largestRectangleArea(heights));
        }
        return res;
    }

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
