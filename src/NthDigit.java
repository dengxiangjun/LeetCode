/**
 * description Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * <p>
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 3
 * <p>
 * Output:
 * 3
 * Example 2:
 * <p>
 * Input:
 * 11
 * <p>
 * Output:
 * 0
 * <p>
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 *
 * @author dengxiangjun@jd.com
 * @date 2018/12/21 15:44
 **/
public class NthDigit {

    public static void main(String[] args) {
        int n = 12;
        int res = findNthDigit(n);
        System.out.println(res);
    }

    public static int findNthDigit(int n) {
        if (n < 10) return n;
        int i = 1;

        while (n > 9 * Math.pow(10, i - 1) * i) {
            n -= 9 * Math.pow(10, i - 1) * i;
            i++;
        }
        int start = (int) Math.pow(10, i - 1);
        int currentNumber = start + (n-1) / i;
        int mod = (n -1) % i;
        String s = String.valueOf(currentNumber);
        String res= s.charAt(mod) + "";
        return Integer.valueOf(res);
    }
}
