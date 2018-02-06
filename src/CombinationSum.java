import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/description/
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p/>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p/>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [
 * [7],
 * [2, 2, 3]
 * ]
 * Created by deng on 2018/2/6.
 */
public class CombinationSum {
    private static List<List<Integer>> lists;

    public static void main(String[] args) {
        int[] candidates = {2, 3, 4, 6, 7};
        List<List<Integer>> lists = combinationSum(candidates, 8);
        System.out.println(lists);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<Integer>();
        lists = new ArrayList<List<Integer>>();
        dfs(candidates, target, 0, list);
        return lists;
    }

    public static void dfs(int[] a, int target, int index, List<Integer> list) {
        if (target > 0) {
            for (int i = index; i < a.length && target >= a[i]; i++) {
                list.add(a[i]);
                dfs(a, target - a[i], i, list);
                list.remove(list.size() - 1);
            }
        } else if (target == 0) lists.add(new ArrayList<Integer>(list));
    }
}
