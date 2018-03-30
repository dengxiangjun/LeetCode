import java.util.Scanner;

/**
 * https://leetcode.com/problems/rotate-image/description/
 * You are given an n x n 2D matrix representing an image.
 * <p/>
 * Rotate the image by 90 degrees (clockwise).
 * <p/>
 * Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * <p/>
 * Example 1:
 * <p/>
 * Given input matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p/>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [7,4,1],b[j][i] = a[len - 1 - i][j];
 * [8,5,2],
 * [9,6,3]
 * ]
 * Example 2:
 * <p/>
 * Given input matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p/>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * Created by deng on 2018/2/11.
 */
public class RotateImage {

    public static void main(String[] args) {
        int[][] a = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(a);
    }

    public static void rotate(int[][] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {//转置
                int tmp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = tmp;
            }

            int j = 0, k = len - 1;
            while (j < k) {//反转整行
                int tmp = a[i][j];
                a[i][j] = a[i][k];
                a[i][k] = tmp;
                j++;
                k--;
            }
        }
    }
}
