import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum/description/
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p/>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p/>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p/>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * Created by deng on 2018/2/11.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] a = {3,3};
        int[] res = twoSum(a, 6);
        for (int i : res)
            System.out.println(i);
    }

    public static int[] twoSum(int[] a, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] res = {0, 0};
        for (int i = 0; i < a.length; i++) {
            if (map.get(target - a[i]) != null) {
                res[0] = map.get(target - a[i]);
                res[1] = i;
            } else map.put(a[i], i);
        }
        return res;
    }
}
