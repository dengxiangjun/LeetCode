/**
 * https://leetcode.com/problems/ugly-number-ii/description/
 * Write a program to find the n-th ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * <p>
 * Example:
 * <p>
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:
 * <p>
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 * Created by admin on 2018/5/11.
 */
public class UglyNumberII {

    public static void main(String[] args) {
        int res = nthUglyNumber(10);
        System.out.println(res);
    }

    /**
     * 1到N的丑数为 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … ；
     * 可以分成如下三组：
     * <p>
     * (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
     * (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
     * (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
     * 1
     * 2
     * 3
     * 只需要保证每次迭代的过程中选取最小的丑数（或者说是质因数），可以理解为后面的数字是前面的数组针对2,3,5的乘积。
     *
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n) {
        int[] num = new int[n];
        num[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i = 1; i < num.length; i++) {
            num[i] = Math.min(num[index2] * 2, Math.min(num[index3] * 3, num[index5] * 5));
            if (num[i] == num[index2] * 2) index2++;
            if (num[i] == num[index3] * 3) index3++;
            if (num[i] == num[index5] * 5) index5++;
        }
        return num[n - 1];
    }
}
