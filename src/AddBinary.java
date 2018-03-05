/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * <p>
 * <p>
 * Created by deng on 2018/3/4.
 */
public class AddBinary {

    public static void main(String[] args) {
        String res = addBinary("11", "11");
        System.out.println(res);
    }

    public static String addBinary(String a, String b) {
        if (a == null || "".equals(a)) return b;
        if (b == null || "".equals(b)) return a;
        int lena = a.length(), lenb = b.length();
        int i = 0, carry = 0;
        String res = "";
        while (i < lena || i < lenb || carry != 0) {
            int x = i < lena ? a.charAt(lena - 1 - i) - '0' : 0;
            int y = i < lenb ? b.charAt(lenb - 1 - i) - '0' : 0;
            res = (x + y + carry) % 2 + res;
            carry = (x + y + carry) / 2;
            i++;
        }
        return res;
    }
}
