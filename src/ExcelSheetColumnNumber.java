/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p/>
 * For example:
 * <p/>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * Example 1:
 * <p/>
 * Input: "A"
 * Output: 1
 * Example 2:
 * <p/>
 * Input: "AB"
 * Output: 28
 * Example 3:
 * <p/>
 * Input: "ZY"
 * Output: 701
 * Created by deng on 2018/5/25.
 */
public class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        String s = "AA";
        int res = titleToNumber(s);
        System.out.print(res);
    }

    public static int titleToNumber(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += (s.charAt(i) - 'A' + 1) * Math.pow(26, s.length() - i - 1);
        }
        return res;
    }
}
