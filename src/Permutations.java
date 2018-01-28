import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/description/
 * Given a collection of distinct numbers, return all possible permutations.
 * <p/>
 * For example,
 * [1,2,3] have the following permutations:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * Created by deng on 2018/1/27.
 */
public class Permutations {
    static List<List<Integer>> lists = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        List<List<Integer>> result = permute(a);
        System.out.println(result);
    }

    public static List<List<Integer>> permute(int[] nums) {
        //List<List<Integer>> lists = new ArrayList<List<Integer>>();
        permute(nums, 0);
        return lists;
    }

    public static void permute(int[] nums, int index) {
        if (index >= nums.length) {
            List<Integer> l = new ArrayList<Integer>();
            for (int i = 0; i < nums.length; i++) l.add(nums[i]);
            lists.add(l);
        }

        for (int i = index; i < nums.length; i++) {
            int tmp = nums[index];
            nums[index] = nums[i];
            nums[i] = tmp;
            permute(nums, index + 1);
            tmp = nums[index];
            nums[index] = nums[i];
            nums[i] = tmp;
        }
    }
}
