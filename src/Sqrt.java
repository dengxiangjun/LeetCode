/**
 * https://leetcode.com/problems/sqrtx/description/
 * Implement int sqrt(int x).
 * <p/>
 * Compute and return the square root of x.
 * <p/>
 * x is guaranteed to be a non-negative integer.
 * <p/>
 * <p/>
 * Example 1:
 * <p/>
 * Input: 4
 * Output: 2
 * Example 2:
 * <p/>
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.
 * Created by deng on 2018/2/12.
 */
public class Sqrt {
    public static void main(String[] args) {
        int res = mySqrt(10);
        System.out.println(res);
    }

    public static int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int l = 0, r = x;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m == x / m) return m;
            else if (m > x / m) r = m - 1;
            else l = m + 1;
        }
        return r;
    }
}
