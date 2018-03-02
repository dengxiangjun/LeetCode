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

    public static void main(String[] args){
        String s = "0.1";
        boolean res = isNumber(s);
    }

    public static boolean isNumber(String s) {
        int i = 0;
        while (i<s.length()){
            //if (s.charAt(i)>='a')
        }
        return false;
    }
}
