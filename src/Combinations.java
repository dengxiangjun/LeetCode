import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/description/
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * For example,
 * If n = 4 and k = 2, a solution is:
 * <p>
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * Created by admin on 2018/3/11.
 */
public class Combinations {

    public static void main(String[] args) {
        List<List<Integer>> res = combine(4, 2);
        System.out.println(res);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> item = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(item, res, 1, n, k);
        return res;
    }

    public static void dfs(List<Integer> item, List<List<Integer>> res, int index, int n, int k) {
        if (item.size() == k) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for (int i = index; i <= n; i++) {
            item.add(i);
            dfs(item, res, i + 1, n, k);
            item.remove(item.size() - 1);
        }
    }
}
