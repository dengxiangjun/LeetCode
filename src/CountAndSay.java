/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p/>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * <p/>
 * Note: Each term of the sequence of integers will be represented as a string.
 * Example 1:
 * <p/>
 * Input: 1
 * Output: "1"
 * Example 2:
 * <p/>
 * Input: 4
 * Output: "1211"
 * 第i+1个字符串是第i个字符串的读法，第一字符串为 “1”
 * 比如第四个字符串是1211，它的读法是 1个1、1个2,2个1，因此第五个字符串是111221。第五个字符串的读法是：3个1、2个2、1个1，因此第六个字符串是312211。
 * Created by deng on 2018/2/5.
 */
public class CountAndSay {
    public static void main(String[] args) {
        String s = countAndSay(4);
        System.out.println(s);
    }

    public static String countAndSay(int n) {
        int i = 1;
        String s = "1";
        while (i < n) {
            char[] ch = s.toCharArray();
            s = "";
            int cur = ch[0], m = 0, cnt = 0;
            while (m < ch.length) {
                if (cur == ch[m]) {
                    cnt++;
                    m++;
                } else {
                    s += "" + cnt + "" + (cur - '0');
                    cur = ch[m];
                    cnt = 0;
                }
            }
            s += "" + cnt + "" + (cur - '0');
            i++;
        }
        return s;
    }
}
