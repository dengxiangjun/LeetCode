import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/description/
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p/>
 * Each number in C may only be used once in the combination.
 * <p/>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * Created by deng on 2018/2/6.
 */
public class CombinationSumII {
    private static List<List<Integer>> lists;

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> lists = combinationSum2(candidates, 8);
        System.out.println(lists);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                dfs(a, target - a[i], i + 1, list);
                list.remove(list.size() - 1);
                while (i + 1 < a.length && a[i] == a[i + 1]) i++;
            }
        } else if (target == 0) lists.add(new ArrayList<Integer>(list));
    }
}
