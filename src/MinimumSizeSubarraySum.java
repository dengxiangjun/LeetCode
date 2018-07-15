/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a contiguous subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead.
 * <p>
 * Example:
 * <p>
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        int s = 7;
        int[] a = {2, 3, 1, 2, 4, 3};
        int res = minSubArrayLen(s, a);
        System.out.println(res);
    }

    /**
     * O(n) 双指针，求窗口大小用双指针
     *
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0;
        int j = 0;
        int min = nums.length + 1;
        int sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            // move the left pointer i to right until sum is smaller than s
            while (sum >= s) {
                min = Math.min(j - i + 1, min);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return min == nums.length + 1 ? 0 : min;
    }
}
