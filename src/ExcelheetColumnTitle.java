/**
 * https://leetcode.com/problems/excel-sheet-column-title/description/
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p/>
 * For example:
 * <p/>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * Example 1:
 * <p/>
 * Input: 1
 * Output: "A"
 * Example 2:
 * <p/>
 * Input: 28
 * Output: "AB"
 * Example 3:
 * <p/>
 * Input: 701
 * Output: "ZY"
 * Created by deng on 2018/5/25.
 */
public class ExcelheetColumnTitle {

    public static void main(String[] args) {
        String res = convertToTitle(703);
        System.out.print(res);
    }

    public static String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            n--;
            res.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }
        return res.toString();
    }
}
