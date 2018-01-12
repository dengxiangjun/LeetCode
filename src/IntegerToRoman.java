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
public class IntegerToRoman {
    public static void main(String[] args) {
        int a = 24;
        String result = intToRoman(a);
        System.out.println(result);
    }

    public static String intToRoman(int num) {
        Map<Integer, Character> map = new HashMap<Integer, Character>();
        int[] arr = {1000,500,100,50,10,5,1};
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');
        int tmp = num;
        StringBuffer sb = new StringBuffer();
        for (int i = 0;i<arr.length;i++){
            while (tmp - arr[i] >= 0) {
                sb.append(map.get(arr[i]));
                tmp -= arr[i];
            }
        }
        return sb.toString();
    }
}
