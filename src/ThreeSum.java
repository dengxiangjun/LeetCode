import java.util.*;

/**
 * https://leetcode.com/problems/3sum/description/
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note: The solution set must not contain duplicate triplets.
 * <p>
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * Created by deng on 2018/3/5.
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] a = {0, 0, 0, 0};
        List<List<Integer>> res = threeSum(a);
    }

    public static List<List<Integer>> threeSum(int[] a) {
        Arrays.sort(a);
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        for (int i = 0; i < a.length - 2; i++) {
            if (i > 0 && a[i - 1] == a[i]) continue;
            twoSum(a, i + 1, -a[i], res);
        }
        return new ArrayList<List<Integer>>(res);
    }

    public static void twoSum(int[] a, int start, int sum, Set<List<Integer>> res) {
        HashSet<Integer> map = new HashSet<Integer>();
        for (int i = start; i < a.length; i++) {
            if (map.contains(sum - a[i])) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(-sum);
                list.add(sum - a[i]);
                list.add(a[i]);
                res.add(list);
            } else map.add(a[i]);
        }
    }
}
