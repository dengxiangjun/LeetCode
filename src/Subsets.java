import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/subsets/description/
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * For example,
 * If nums = [1,2,3], a solution is:
 * <p>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * Created by admin on 2018/3/11.
 */
public class Subsets {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        List<List<Integer>> res = subsets(a);
        System.out.println(res);
    }

    public static List<List<Integer>> subsets(int[] a) {
        List<Integer> item = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(a, item, res, 0);
        return res;
    }

    public static void backtrack(int[] a, List<Integer> item, List<List<Integer>> res, int index) {
        res.add(new ArrayList<Integer>(item));
        for (int j = index; j < a.length; j++) {
            item.add(a[j]);
            backtrack(a, item, res, j + 1);
            item.remove(item.size() - 1);
        }
    }
}
