/**
 * https://leetcode.com/problems/maximum-subarray/description/
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <p>
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * Created by deng on 2018/2/27.
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res = maxSubArray(a);
        System.out.println(res);
    }

    /**
     * O(n)解法
     *
     * @param a
     * @return
     */
    public static int maxSubArray(int[] a) {
        if (a == null) return 0;
        if (a.length == 1) return a[0];
        int max = a[0], res = a[0];
        for (int i = 1; i < a.length; i++) {
            max = Math.max(a[i], a[i] + max);
            res = Math.max(res, max);
        }
        return res;
    }
}
