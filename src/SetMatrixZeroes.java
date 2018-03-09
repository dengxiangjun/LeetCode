/**
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * Created by deng on 2018/3/8.
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 0, 5}, {7, 8, 0}};
        setZeroes(a);
    }

    public static void setZeroes(int[][] a) {
        boolean fr = false, fc = false;
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 0) {
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;
                    a[i][0] = 0;//表示该列需要清零
                    a[0][j] = 0;//表示该行需要清零
                }
            }

        for (int i = 1; i < a.length; i++)
            for (int j = 1; j < a[0].length; j++) {
                if (a[i][0] == 0 || a[0][j] == 0) a[i][j] = 0;
            }

        if (fr) for (int i = 0; i < a[0].length; i++) a[0][i] = 0;//第一行清零

        if (fc) for (int i = 0; i < a.length; i++) a[i][0] = 0;//第一列清零
    }
}
