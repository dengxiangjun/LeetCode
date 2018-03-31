import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * <p>
 * Your algorithm should run in O(n) complexity.
 * <p>
 * <p>
 * Created by admin on 2018/3/31.
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] a = {100, 4, 200, 1, 3, 2};
        int res = longestConsecutive(a);
        System.out.println(res);
    }

    /**
     * 使用HashSet
     * @param a
     * @return
     */
    public static int longestConsecutive(int[] a) {
        if (a == null || a.length == 0) return 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int item : a) set.add(item);
        int res = 1;
        for (int i = 0; i < a.length; i++) {
            int down = a[i] - 1;
            while (set.contains(down)) set.remove(down--);
            int up = a[i] + 1;
            while (set.contains(up)) set.remove(up++);
            res = Math.max(res, up - down - 1);
        }
        return res;
    }
}
