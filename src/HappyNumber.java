import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number/description/
 * Write an algorithm to determine if a number is "happy".
 * <p/>
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 * <p/>
 * Example:
 * <p/>
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * Created by deng on 2018/5/26.
 */
public class HappyNumber {

    public static void main(String[] args) {
        int m = 19;
        boolean res = isHappy(m);
        System.out.println(res);
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        while (n != 1) {
            int next = 0;
            while (n != 0) {
                int mod = n % 10;
                next += mod * mod;
                n /= 10;
            }
            n = next;
            if (set.contains(next)) return false;
            set.add(next);
        }
        return true;
    }
}
