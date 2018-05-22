/**
 * https://leetcode.com/problems/maximum-product-subarray/description/
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p/>
 * Example 1:
 * <p/>
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * <p/>
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * Created by deng on 2018/5/22.
 */
public class MaximumProductSubarray {

    public static void main(String[] args) {
        int[] a = {2, 3, -2, 4};
        int res = maxProduct(a);
        System.out.println(res);
    }

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = nums[0], max = nums[0], min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(min * nums[i],Math.max(nums[i],max * nums[i]));
            min = Math.min(min * nums[i], Math.min(nums[i], temp * nums[i]));
            res = Math.max(res,max);
        }
        return res;
    }
}
