/**
 * https://leetcode.com/problems/fraction-to-recurring-decimal/description/
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * <p/>
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * <p/>
 * Example 1:
 * <p/>
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * Example 2:
 * <p/>
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * Example 3:
 * <p/>
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 * <p/>
 * Created by deng on 2018/5/24.
 */
public class FractiontoRecurringDecimal {

    public static void main(String[] args) {
        int numerator = 2;
        int denominator = 3;
        String res = fractionToDecimal(numerator, denominator);
        System.out.println(res);
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        if (denominator == 1) return numerator + "";
        return "";
    }
}
