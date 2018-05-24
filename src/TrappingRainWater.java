/**
 * https://leetcode.com/problems/trapping-rain-water/description/
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * <p>
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * <p>
 * <p>
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
 * 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * Created by deng on 2018/2/6.
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int res = trap(a);
        System.out.println(res);
    }

    public static int trap(int[] a) {
        if (a == null || a.length == 1) return 0;
        int res = 0, left = 0, right = a.length - 1, leftMax = 0, rightMax = 0;
        while (left < right) {
            if (a[left] < a[right]) {
                leftMax = Math.max(leftMax, a[left]);
                res += leftMax - a[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, a[right]);
                res += rightMax - a[right];
                right--;
            }
        }
        return res;
    }

//    public static int trap(int[] a) {
//        if (a == null || a.length == 1) return 0;
//        int res = 0, max = 0;
//        int[] container = new int[a.length];
//        for (int i = 0; i < a.length; i++) {
//            max = Math.max(max, a[i]);
//            container[i] = max;
//        }
//
//        max = 0;
//        for (int i = a.length - 1; i >= 0; i--) {
//            max = Math.max(max, a[i]);
//            container[i] = Math.min(max, container[i]);
//            res += (container[i] - a[i] > 0 ? container[i] - a[i] : 0);
//        }
//        return res;
//    }
}
