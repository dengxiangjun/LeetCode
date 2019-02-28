/**
 * https://leetcode.com/problems/remove-k-digits/
 * description Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 * <p>
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 * <p>
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 * <p>
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 * <p>
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 *
 * @author dengxiangjun@jd.com
 * @date 2018/12/21 14:38
 **/
public class RemoveKDigits {

    public static void main(String[] args) {
        String num = "10200";
        int k = 3;
        String res = removeKdigits(num, k);
        System.out.println(res);
    }

    /**
     * 贪心算法
     * @param num
     * @param k
     * @return
     */
    public static String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        while (k > 0) {
            int i = 1;
            while (i < num.length()) {
                if (num.charAt(i - 1) > num.charAt(i)) {
                    break;
                }
                i++;
            }
            num = num.substring(0, i - 1) + num.substring(i);
            k--;
        }

        int i = 0;
        for (; i < num.length(); i++) if (num.charAt(i) != '0') break;
        return i == num.length() ? "0" : num.substring(i);
    }
}
