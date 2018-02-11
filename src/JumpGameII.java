/**
 * https://leetcode.com/problems/jump-game-ii/description/
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p/>
 * Each element in the array represents your maximum jump length at that position.
 * <p/>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p/>
 * For example:
 * Given array A = [2,3,1,1,4]
 * <p/>
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * <p/>
 * Note:
 * You can assume that you can always reach the last index.
 * Created by deng on 2018/2/9.
 */
public class JumpGameII {

    public static void main(String[] args) {
        int[] a = {1,2};
        int res = jump(a);
        System.out.println(res);
    }

    public static int jump(int[] a) {
        int ret = 0;
        int last = 0;
        int curr = 0;
        int i = 0;
        for (; i < a.length && i <= curr; ++i) {
            if (i > last) {
                last = curr;
                ++ret;
            }
            curr = Math.max(curr, i + a[i]);
        }

        if (i < a.length - 1) return 0;
        return ret;
    }
}
