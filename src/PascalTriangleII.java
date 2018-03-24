import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * <p>
 * For example, given k = 3,
 * Return [1,3,3,1].
 * <p>
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 * Created by admin on 2018/3/24.
 */
public class PascalTriangleII {

    public static void main(String[] args) {
        List<Integer> res = getRow(3);
        System.out.println(res);
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> item = new ArrayList<Integer>();
        if (rowIndex == 0) {
            item.add(1);
            return item;
        }
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                item.set(j, item.get(j - 1) + item.get(j));
            }
        }
        return item;
    }
}
