/**
 * Given two binary strings, return their sum (also a binary string).
 * <p/>
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * <p/>
 * <p/>
 * Created by deng on 2018/3/4.
 */
public class AddBinary {

    public static void main(String[] args) {
        String res = addBinary("11", "1");
        System.out.println(res);
    }

    public static String addBinary(String a, String b) {
        if (a == null || "".equals(a)) return b;
        if (b == null || "".equals(b)) return a;
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        int len = a.length(), carry = 0,diff = len - b.length();
        String sb = "";
        int i = len - 1;
        for (; i >= 0 && len - i <= b.length(); i--) {
            int c1 = a.charAt(i) - '0', c2 = b.charAt(i - diff) - '0';
            int sum = c1 + c2 + carry;
            if (sum == 1){
                sb = "1" + sb;
                carry = 0;
            } else if (sum == 2){
                sb ="0" + sb;
                carry = 1;
            }else {
                sb ="1" + sb;
                carry = 1;
            }
        }
        if (i>=0) sb=a.substring(0,i) + sb;
        return sb;
    }
}
