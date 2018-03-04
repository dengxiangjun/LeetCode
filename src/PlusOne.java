/**
 * https://leetcode.com/problems/plus-one/description/
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * <p>
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 * <p>
 * <p>
 * Created by deng on 2018/3/4.
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] a = {9, 9, 9};
        int[] res = plusOne(a);
        StringBuilder sb = new StringBuilder();
        for (int i : res) sb.append(i);
        System.out.println(sb.toString());
    }

    public static int[] plusOne(int[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] + 1 > 9) {
                a[i] = a[i] - 9;
            } else {
                a[i] = a[i] + 1;
                return a;
            }
        }
        int[] res = new int[a.length + 1];
        res[0] = 1;
        for (int i = 0; i < a.length; i++) res[i + 1] = a[i];
        return res;
    }
}
