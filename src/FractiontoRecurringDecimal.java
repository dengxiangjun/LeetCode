import java.util.HashMap;

/**
 * https://leetcode.com/problems/fraction-
 * to-recurring-decimal/description/
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
        int numerator = 4;
        int denominator = 333;
        String res = fractionToDecimal(numerator, denominator);
        System.out.println(res);
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        // integral part
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }

        // fractional part
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }
}
