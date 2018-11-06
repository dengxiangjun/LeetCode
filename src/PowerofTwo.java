/**
 * https://leetcode.com/problems/power-of-two/description/
 * Given an integer, write a function to determine if it is a power of two.
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 * Example 2:
 * <p>
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 * Example 3:
 * <p>
 * Input: 218
 * Output: false
 */
public class PowerofTwo {

    public static void main(String[] args) {
        boolean res = isPowerOfTwo(-16);
        System.out.println(res);
    }

//    public static boolean isPowerOfTwo(int n) {
//        if (n <= 0) return false;
//        if (n == 1) return true;
//        if (n % 2 == 1) return false;
//        while (n != 1) {
//            if (n % 2 == 1) return false;
//            n /= 2;
//        }
//        return true;
//    }

    /**
     * 位运算
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && ((n - 1) & n) == 0;
    }
}
