/**
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p/>
 * For example,
 * Given n = 3,
 * <p/>
 * You should return the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 * Created by deng on 2018/2/28.
 */
public class SpiralMatrixII {

    public static void main(String[] args) {
        int[][] res = generateMatrix(3);
        System.out.println(res);
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int cnt = 0;
        int rowBegin = 0, rowEnd = n - 1, colBegin = 0, colEnd = n - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) res[rowBegin][i] = ++cnt;
            rowBegin++;
            for (int i = rowBegin; i <= rowEnd; i++) res[i][colEnd] = ++cnt;
            colEnd--;
            for (int i = colEnd; i >= colBegin; i--) res[rowEnd][i] = ++cnt;
            rowEnd--;
            for (int i = rowEnd; i >= rowBegin; i--) res[i][colBegin] = ++cnt;
            colBegin++;
        }
        return res;
    }
}
