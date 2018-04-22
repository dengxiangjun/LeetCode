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
        return 0;
    }
}
