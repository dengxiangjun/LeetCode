/**
 * https://leetcode.com/problems/single-number/description/
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,1,2,1,2]
 * Output: 4
 * <p>
 * Created by deng on 2018/4/22.
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] a = { 1, 1, 2, 2,4};
        int res = singleNumber(a);
        System.out.println(res);
    }

    public static int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++){
            res = res ^ nums[i];
        }
        return res;
    }
}
