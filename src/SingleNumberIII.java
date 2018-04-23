/**
 * https://leetcode.com/problems/single-number-iii/description/
 * Given an array of numbers nums, in which exactly two elements appear only once and
 * all the other elements appear exactly twice. Find the two elements that appear only once.
 * <p>
 * For example:
 * <p>
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * <p>
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * Created by admin on 2018/4/23.
 */
public class SingleNumberIII {

    public static void main(String[] args) {
        int[] a = {1, 2, 1, 3, 2, 5};
        int[] res = singleNumber(a);
        System.out.println(res);
    }

    public static int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) diff ^=num;
        diff &= -diff;
        int[] res = new int[2];
        for (int num : nums){
            if ((num & diff) == 0) res[0] ^= num;
            else res[1] ^= num;
        }
        return res;
    }
}
