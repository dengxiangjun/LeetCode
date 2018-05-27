/**
 * https://leetcode.com/problems/reverse-bits/description/
 * Reverse bits of a given 32 bits unsigned integer.
 * <p/>
 * Example:
 * <p/>
 * Input: 43261596
 * Output: 964176192
 * Explanation: 43261596 represented in binary as 00000010100101000001111010011100,
 * return 964176192 represented in binary as 00111001011110000010100101000000.
 * Follow up:
 * If this function is called many times, how would you optimize it?
 * Created by deng on 2018/5/27.
 */
public class ReverseBits {

    public static void main(String[] args) {
        int m = 1;
        int res = reverseBits(m);
        System.out.println(res);
    }

    public static int reverseBits(int n) {
        if (n == 0) return 0;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += n & 1;
            n >>>= 1;
            if (i < 31) res <<= 1;
        }
        return res;
    }
}
