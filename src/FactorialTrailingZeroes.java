/**
 * https://leetcode.com/problems/factorial-trailing-zeroes/description/
 * Given an integer n, return the number of trailing zeroes in n!.
 * <p/>
 * Example 1:
 * <p/>
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 * <p/>
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Note: Your solution should be in logarithmic time complexity.
 * <p/>
 * <p/>
 * Created by deng on 2018/5/25.
 */
public class FactorialTrailingZeroes {

    public static void main(String[] args) {
        int res = trailingZeroes(15);
        System.out.print(res);
    }

    public static int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}
