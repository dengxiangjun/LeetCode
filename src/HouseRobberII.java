/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
 * Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two
 * adjacent houses were broken into on the same night.
 * <p/>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum
 * amount of money you can rob tonight without alerting the police.
 * <p/>
 * Example 1:
 * <p/>
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 * because they are adjacent houses.
 * Example 2:
 * <p/>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Created by deng on 2018/5/13.
 */
public class HouseRobberII {

    public static void main(String[] args) {
        int[] a = {1,2,3,1};
        int res = rob(a);
        System.out.println(res);
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    public static int rob(int[] a, int left, int right) {
        int[] dp = new int[a.length];
        for (int i = left; i <= right; i++) {
            if (i == left) dp[i] = a[i];
            else if (i == left + 1) dp[i] = Math.max(a[i - 1], a[i]);
            else dp[i] = Math.max(dp[i - 1], dp[i - 2] + a[i]);
        }
        return dp[right];
    }
}
