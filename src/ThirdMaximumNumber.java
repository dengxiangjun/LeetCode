/**
 * https://leetcode.com/problems/third-maximum-number/description/
 * Given a non-empty array of integers, return the third maximum number in this array.
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 * <p>
 * Example 1:
 * Input: [3, 2, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 * <p>
 * Output: 2
 * <p>
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */
public class ThirdMaximumNumber {

    public static void main(String[] args) {
        int[] a = {1,2,-2147483648};
        int res = thirdMax(a);
        System.out.println(res);
    }

    public static int thirdMax(int[] nums) {
        int max = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        for (int item : nums) {
            if (item > max) max = item;
        }

        for (int item : nums) {
            if (item > second && item < max) second = item;
        }

        boolean hasMinVal = false;
        for (int item : nums) {
            if (item > third && item < second) third = item;
            if (item == Integer.MIN_VALUE) hasMinVal = true;
        }
        if ((second == Integer.MIN_VALUE) || (!hasMinVal && third == Integer.MIN_VALUE)) return max;
        else return third;
    }
}
