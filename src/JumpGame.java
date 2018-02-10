/**
 * https://leetcode.com/problems/jump-game/description/
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p/>
 * Each element in the array represents your maximum jump length at that position.
 * <p/>
 * Determine if you are able to reach the last index.
 * <p/>
 * For example:
 * A = [2,3,1,1,4], return true.
 * <p/>
 * A = [3,2,1,0,4], return false.
 * <p/>
 * <p/>
 * Created by deng on 2018/2/10.
 */
public class JumpGame {

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 1, 4};
        boolean res = canJump(a);
        System.out.println(res);
    }

    public static boolean canJump(int[] nums) {
        if (nums.length < 2) return true;
        int reach = 0;
        for (int i = 0; i < nums.length - 1 && i <= reach; i++) {
            reach = Math.max(reach, i + nums[i]);//更新当前位置所能跳到的最大距离
            if (reach >= nums.length - 1) return true;
        }
        return false;
    }
}
