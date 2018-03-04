/**
 * https://leetcode.com/problems/valid-number/description/
 * Validate if a given string is numeric.
 * <p>
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 * <p>
 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument,
 * please click the reload button  to reset your code definition.
 * Created by deng on 2018/3/2.
 */
public class ValidNumber {

    public static void main(String[] args) {
        String s = "0.1";
        boolean res = isNumber(s);
    }

    public static boolean isNumber(String s) {
        s = s.trim();
        boolean numberSeen = false, pointSeen = false, eSeen = false, numberAfterE = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if (s.charAt(i) == '.') {
                if (eSeen || pointSeen) return false;
                pointSeen = true;
            } else if (s.charAt(i) == 'e') {
                if (eSeen || !numberSeen) return false;
                eSeen = true;
                numberAfterE = false;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            } else return false;
        }
        return numberSeen && numberAfterE;
    }
}
