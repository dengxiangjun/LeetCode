import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations-ii/description/
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p/>
 * For example,
 * [1,1,2] have the following unique permutations:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * Created by deng on 2018/1/27.
 */
public class PermutationsII {
    private static List<List<Integer>> lists = new ArrayList<List<Integer>>();

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2};
        List<List<Integer>> result = permuteUnique(a);
        System.out.println(result);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        Arrays.sort(nums);
        boolean[] isVisited = new boolean[nums.length];
        List<Integer> item = new ArrayList<Integer>();
        dfsHelper(list, item, isVisited, nums);
        return list;
    }

    public static void dfsHelper(List<List<Integer>> list, List<Integer> item, boolean[] isVisited, int[] nums) {
        if (item.size() == nums.length) {
            list.add(new ArrayList<Integer>(item));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && !isVisited[i - 1]) {
                continue;
            }
            if (!isVisited[i]) {
                item.add(nums[i]);
                isVisited[i] = true;
                dfsHelper(list, item, isVisited, nums);
                isVisited[i] = false;
                item.remove(item.size() - 1);
            }
        }
    }

//    public static List<List<Integer>> permuteUnique(int[] nums) {
//        lists.clear();
//        Arrays.sort(nums);
//        permute(nums, 0);
//        return lists;
//    }
//
//    public static void permute(int[] nums, int index) {
//        if (index >= nums.length) {
//            List<Integer> l = new ArrayList<Integer>();
//            for (int i = 0; i < nums.length; i++) l.add(nums[i]);
//            lists.add(l);
//        }
//
//        for (int i = index; i < nums.length; i++) {
//            if (i != index && nums[i] == nums[index]) continue;
//            int tmp = nums[index];
//            nums[index] = nums[i];
//            nums[i] = tmp;
//            permute(nums, index + 1);
//            tmp = nums[index];
//            nums[index] = nums[i];
//            nums[i] = tmp;
//
//        }
//    }
}
