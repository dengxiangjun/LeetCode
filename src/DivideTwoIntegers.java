/**
 * https://leetcode.com/problems/divide-two-integers/description/
 * Divide two integers without using multiplication, division and mod operator.
 * <p/>
 * If it is overflow, return MAX_INT.
 * Created by deng on 2018/1/26.
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        int dividend = -2147483648, divisor = 2;
        int result = divide(dividend, divisor);
        System.out.println(result);
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1) return -dividend;
        int res = 0;
        double a = Math.abs((double) dividend), b = Math.abs((double) divisor);
        while (a >= b) {
            double multiOfDivisor = 1;
            double tmp = b;
            while (tmp + tmp <= a) {
                tmp += tmp;
                multiOfDivisor += multiOfDivisor;
            }
            res += multiOfDivisor;
            a -= tmp;
        }

        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) return -res;
        else return res;
    }
}
