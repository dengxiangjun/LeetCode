/**
 * https://leetcode.com/problems/count-primes/description/
 * Description:
 * <p>
 * Count the number of prime numbers less than a non-negative number, n.
 * Created by admin on 2018/4/20.
 */
public class CountPrimes {

    public static void main(String[] args) {
        int res = countPrimes(10);
        System.out.println(res);
    }

    public static int countPrimes(int n) {
        if (n < 1) return 0;
        boolean[] hash = new boolean[n];
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (!hash[i]) {
                res++;
                for (int j = 2; i * j < n; j++) hash[i * j] = true;
            }
        }
        return res;
    }
}
