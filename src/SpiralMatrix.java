import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/description/
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p/>
 * For example,
 * Given the following matrix:
 * <p/>
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 * Created by deng on 2018/2/27.
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] a = {{1,2}, {3,4}};
        List<Integer> list = spiralOrder(a);
        for (int item : list) System.out.println(item);
    }

    public static List<Integer> spiralOrder(int[][] a) {
        List<Integer> res = new ArrayList<Integer>();
        if (a == null || a.length == 0) return res;
        int rowBegin = 0, rowEnd = a.length - 1, colBegin = 0, colEnd = a[0].length - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) res.add(a[rowBegin][i]);
            rowBegin++;
            for (int i = rowBegin; i <= rowEnd; i++) res.add(a[i][colEnd]);
            colEnd--;
            if (rowBegin <= rowEnd)
                for (int i = colEnd; i >= colBegin; i--) res.add(a[rowEnd][i]);
            rowEnd--;
            if (colBegin <= colEnd)
                for (int i = rowEnd; i >= rowBegin; i--) res.add(a[i][colBegin]);
            colBegin++;
        }
        return res;
    }
}
