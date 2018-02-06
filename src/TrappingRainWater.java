/**
 * https://leetcode.com/problems/trapping-rain-water/description/
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * <p/>
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * <p/>
 * <p/>
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
 * 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * Created by deng on 2018/2/6.
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] a = {4, 2, 3};
        int res = trap(a);
        System.out.println(res);
    }

    public static int trap(int[] a) {
        if (a == null || a.length == 1) return 0;
        int i = 0;
        while (i < a.length && a[i] == 0) i++;
        int j = i + 1;
        int res = 0;
        int bottom = a[i];
        while (j < a.length) {
            if (a[j] < a[i]) {
                //if (i + 1 == j) bottom = a[j];
                j++;
            } else if (i + 1 == j && a[j] >= a[i]) {
                i++;
                j++;
            } else if (i + 1 < j && a[j] > a[i]) {
                int height = Math.min(a[i], a[j]);
                res += height * (j - i - 1);
                i++;
                while (i < j) {
                    res -= a[i];
                    i++;
                }
                j++;
            }
        }
        return res;
    }
}
