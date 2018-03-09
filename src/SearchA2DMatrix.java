/**
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * <p>
 * Consider the following matrix:
 * <p>
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * Created by deng on 2018/3/9.
 */
public class SearchA2DMatrix {

    public static void main(String[] args) {
        int[][] a = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        boolean res = searchMatrix(a, 150);
        System.out.println(res);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int n = matrix.length;
        int m = matrix[0].length;
        if(m==0) return false;
        int l = 0, r = m * n - 1;
        while (l != r){
            int mid = (l + r - 1) >> 1;
            if (matrix[mid / m][mid % m] < target)
                l = mid + 1;
            else
                r = mid;
        }
        return matrix[r / m][r % m] == target;
    }
}
