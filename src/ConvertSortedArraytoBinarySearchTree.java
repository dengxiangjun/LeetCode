/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p/>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p/>
 * <p/>
 * Example:
 * <p/>
 * Given the sorted array: [-10,-3,0,5,9],
 * <p/>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p/>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * <p/>
 * Created by deng on 2018/3/23.
 */
public class ConvertSortedArraytoBinarySearchTree {

    public static void main(String[] args) {
        int[] a = {-10, -3, 0, 5, 9};
        TreeNode res = sortedArrayToBST(a);
        System.out.println(res);
    }

    public static TreeNode sortedArrayToBST(int[] a) {
        TreeNode root = construct(a, 0, a.length - 1);
        return root;
    }

    public static TreeNode construct(int[] a, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(a[mid]);
        root.left = construct(a, start, mid - 1);
        root.right = construct(a, mid + 1, end);
        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
