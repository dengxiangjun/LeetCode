/**
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 * Implement atoi to convert a string to an integer.
 * <p>
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * <p>
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 * <p>
 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
 * Created by deng on 2018/1/7.
 */
public class StringToInteger {
    public static void main(String[] args) {
        String a = "    -2";
        int result = myAtoi(a);
        System.out.println(result);
    }

    public static int myAtoi(String str) {
        if ("".equals(str)) return 0;
        char[] c = str.toCharArray();
        int len = c.length;
        int i = 0;
        int sign = 1;
        while (c[i] == ' ') i++;
        if (c[i] == '-') {
            sign = -1;
            i++;
        } else if (c[i] == '+') i++;

        int result = 0;
        while (i < len) {
            if (c[i] < '0' || c[i] > '9') break;
            int tail = c[i] - '0';
            if (sign == 1) {
                if (result > Integer.MAX_VALUE / 10
                        || result == Integer.MAX_VALUE / 10 && tail > Integer.MAX_VALUE % 10)
                    return sign * Integer.MAX_VALUE;
            } else {
                if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && tail > Integer.MIN_VALUE % 10 + 1)
                    return Integer.MIN_VALUE;
            }

            result = result * 10 + tail;
            i++;
        }
        return sign * result;
    }
}
