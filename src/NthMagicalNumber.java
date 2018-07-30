/**
 * https://leetcode.com/contest/weekly-contest-95/problems/nth-magical-number/
 * A positive integer is magical if it is divisible by either A or B.
 * <p>
 * Return the N-th magical number.  Since the answer may be very large, return it modulo 10^9 + 7.
 * Example 1:
 * <p>
 * Input: N = 1, A = 2, B = 3
 * Output: 2
 * Example 2:
 * <p>
 * Input: N = 4, A = 2, B = 3
 * Output: 6
 * Example 3:
 * <p>
 * Input: N = 5, A = 2, B = 4
 * Output: 10
 * Example 4:
 * <p>
 * Input: N = 3, A = 6, B = 4
 * Output: 8
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 10^9
 * 2 <= A <= 40000
 * 2 <= B <= 40000
 */
public class NthMagicalNumber {


    public static void main(String[] args) {
        int res = nthMagicalNumber(8, 10, 5);
        System.out.println(res);
    }

    public static int nthMagicalNumber(int N, int A, int B) {
        long low = 1, high = Long.MAX_VALUE;
        int M = 1000000007;
        while (low < high) {
            long mid = low + (high - low) / 2;
            long ac = mid / A;
            long bc = mid / B;
            long cc = mid/ (A * B / gcd(A, B));
            long count = ac + bc - cc;
            if (count >= N) high = mid;
            else low = mid + 1;
        }
        return (int) (low % M);
    }

    public static int gcd(int A, int B) {
        if (A < B) {
            int tmp = A;
            A = B;
            B = tmp;
        }
        if (A % B == 0) return B;
        return gcd(B, A % B);
    }
}
