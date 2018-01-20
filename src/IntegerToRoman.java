import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/description/
 * Given a roman numeral, convert it to an integer.
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * <p>
 * Created by deng on 2018/1/11.
 */
public class IntegerToRoman {
    public static void main(String[] args) {
        int a = 99;
        String result = intToRoman(a);
        System.out.println(result);
    }

//    /**
//     * 贪心算法
//     * @param num
//     * @return
//     */
//    public static String intToRoman(int num) {
//        Map<Integer, String> map = new HashMap<Integer, String>();
//        int[] a = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
//        String[] s = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i< a.length;i++){
//            while (num > a[i]){
//                num -= a[i];
//                sb.append(s[i]);
//            }
//        }
//        return sb.toString();
//    }

    /**
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        StringBuilder sb = new StringBuilder();
        sb.append(M[num / 1000]).append(C[num % 1000 / 100]).append(X[num % 100 / 10]).append(I[num % 10]);
        return sb.toString();
    }
}
