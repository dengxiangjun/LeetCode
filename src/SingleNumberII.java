/**
 * https://leetcode.com/problems/single-number-ii/description/
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,3,2]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 * Created by deng on 2018/4/22.
 */
public class SingleNumberII {

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 1, 0, 1, 99};
        int res = singleNumber(a);
        System.out.println(res);
    }

    public static int singleNumber(int[] nums) {
        int[] bit = new int[32];//把每个数字的bit相应位加起来
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                bit[j] += nums[i] >>> j & 1;
            }
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (bit[i] % 3 != 0) res += (bit[i] % 3) << i;//所有数字的bit加起来的和对3取模，如果不为0，则说明是只出现一次的数字的bit位
        }
        return res;
    }
}
