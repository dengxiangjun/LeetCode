/**
 * https://leetcode.com/problems/number-of-1-bits/description/
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 * <p/>
 * Example 1:
 * <p/>
 * Input: 11
 * Output: 3
 * Explanation: Integer 11 has binary representation 00000000000000000000000000001011
 * Example 2:
 * <p/>
 * Input: 128
 * Output: 1
 * Explanation: Integer 128 has binary representation 00000000000000000000000010000000
 * Created by deng on 2018/5/26.
 */
public class Numberof1Bits {

    public static void main(String[] args) {
        int m = 128;
        int res = hammingWeight(m);
        System.out.println(res);
    }

    public static int hammingWeight(int n) {
        if (n == 0) return 0;
        int res = 0;
        while (n != 0){
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}
