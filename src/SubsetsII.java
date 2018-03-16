import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/description/
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * For example,
 * If nums = [1,2,2], a solution is:
 * <p>
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class SubsetsII {

    public static void main(String[] args) {
        int[] a = {1, 2, 2};
        List<List<Integer>> res = subsetsWithDup(a);
        System.out.println(res);
    }

    public static List<List<Integer>> subsetsWithDup(int[] a) {
        List<Integer> item = new ArrayList<Integer>();
        Arrays.sort(a);
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
            while (j < a.length - 1 && a[j] == a[j + 1]) j++;
        }
    }
}
