/**
 * https://leetcode.com/problems/multiply-strings/description/
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 * <p/>
 * Note:
 * <p/>
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * Created by deng on 2018/2/8.
 */
public class MultiplyStrings {

    public static void main(String[] args) {
        String a = "123456789", b = "2";
        //String a = "40", b = "60";
        String res = multiply(a, b);
        System.out.println(res);
    }

    public static String multiply(String a, String b) {
        if (a == null || b == null || "".equals(a) || "".equals(b) || "0".equals(a) || "0".equals(b)) return "0";
        int m = a.length(), n = b.length();
        int[] pos = new int[m + n];
        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--) {
                int mul = (a.charAt(i) - '0') * (b.charAt(j) - '0');
                int p = i + j, q = i + j + 1;
                int sum = mul + pos[q];
                pos[p] += (sum / 10);
                pos[q] = sum % 10;
            }
        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.toString();
    }
}
