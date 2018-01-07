package com.dxj.tp;

/**
 * https://leetcode.com/problems/implement-strstr/description/
 * Implement strStr().

 Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 Example 1:

 Input: haystack = "hello", needle = "ll"
 Output: 2
 Example 2:

 Input: haystack = "aaaaa", needle = "bba"
 Output: -1
 * Created by deng on 2017/11/12.
 */
public class ImplementStrStr {
    public static void main(String[] args) {

        int index = strStr("aabaaabaaac", "aabaaac");
        System.out.println(index);
    }

    /**
     * 蛮力法
     * @param haystack
     * @param needle
     * @return
     */
//    public int strStr(String haystack, String needle) {
//        int len1 = haystack.length(), len2 = needle.length();
//        int i = 0, j = 0;
//        while (i < len1 && j < len2) {
//            if (haystack.charAt(i) == needle.charAt(j)) {
//                i++;
//                j++;
//            } else {
//                i = i - j + 1;
//                j = 0;
//            }
//        }
//        if (j == len2) return i-j;
//        else return -1;
//    }

    /**
     * KMP算法
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        int m = haystack.length(),n = needle.length();
        if (m == 0 || n == 0) return -1;
        int[] next = getNext(needle.toCharArray());
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == n) return i-j;
        else return -1;
    }

//    /**
//     * KMP算法的next数组
//     * @param p
//     * @return
//     */
//    public static int[] getNext(char[] p){
//        int[] next = new int[p.length];
//        next[0] = -1;
//        int k = -1, j = 0;
//        while (j < p.length -1){
//            if (k == -1 || p[k] == p[j]) next[++j] = ++k;
//            else k = next[k];//寻找更短的前缀
//        }
//        return next;
//    }

    /**
     * KMP算法的next数组优化，跳过next[++k]与next[++j]相等的情况
     * @param p
     * @return
     */
    public static int[] getNext(char[] p){
        int[] next = new int[p.length];
        next[0] = -1;
        int k = -1, j = 0;
        while (j < p.length -1){
            if (k == -1 || p[k] == p[j]) {
                ++j;
                ++k;
                if (p[j] == p[k]) next[j] = next[k];
                else next[j] = k;
            }
            else k = next[k];//寻找更短的前缀
        }
        return next;
    }
}
