import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/description/
 * Given numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * For example, given numRows = 5,
 * Return
 * <p>
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * Created by admin on 2018/3/24.
 */
public class PascalTriangle {

    public static void main(String[] args) {
        List<List<Integer>> res = generate(5);
        System.out.println(res);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows == 0) return res;
        for (int i = 0; i < numRows; i++) {
            List<Integer> item = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) item.add(1);
                else {
                    List<Integer> prev = res.get(i - 1);
                    item.add(prev.get( j -1) + prev.get(j));
                }
            }
            res.add(item);
        }
        return res;
    }
}
