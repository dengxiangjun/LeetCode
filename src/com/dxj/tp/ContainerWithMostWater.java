package com.dxj.tp;

/**
 * https://leetcode.com/problems/container-with-most-water/description/
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p/>
 * Note: You may not slant the container and n is at least 2.
 * <p/>
 * Created by deng on 2018/1/11.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] a = {1, 4, 7, 10, 8, 4};
        int index = maxArea(a);
        System.out.println(index);
    }

    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(max, area);
            if (height[i] < height[j]) i++;
            else j--;
        }
        return max;
    }
}
