import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/description/
 * Given a roman numeral, convert it to an integer.
 * <p/>
 * Input is guaranteed to be within the range from 1 to 3999.
 * <p/>
 * <p/>
 * Created by deng on 2018/1/11.
 */
public class RomanToInteger {
    public static void main(String[] args) {
        String s = "MDCCCLXXXIV";
        int result = romanToInt(s);
        System.out.println(result);
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        map.put('L', 50);
        char[] c = s.toCharArray();
        int result = 0;
        for (int i = 0; i < c.length; i++) {
            int tail;
            if ((i + 1) < c.length && map.get(c[i]) < map.get(c[i + 1])){
                tail = map.get(c[i + 1]) - map.get(c[i]);
                i++;
            }else tail = map.get(c[i]);
            result += tail;
        }
        return result;
    }
}
