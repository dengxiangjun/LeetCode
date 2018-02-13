/**
 * https://leetcode.com/problems/powx-n/description/
 * Implement pow(x, n).
 * <p/>
 * <p/>
 * Example 1:
 * <p/>
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 * <p/>
 * Input: 2.10000, 3
 * Output: 9.26100
 * Created by deng on 2018/2/12.
 */
public class Pow {

    public static void main(String[] args) {
        double res = myPow(2,-2147483648);
        System.out.println(res);
    }

    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        if(n == Integer.MIN_VALUE){
            x = x * x;
            n = n/2;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        if (n % 2 == 0)
            return myPow(x * x, n / 2);
        else return x * myPow(x * x, n / 2);
    }
}
