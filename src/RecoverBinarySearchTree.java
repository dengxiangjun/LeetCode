/**
 * https://leetcode.com/problems/recover-binary-search-tree/description/
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * <p>
 * Recover the tree without changing its structure.
 * <p>
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * Created by deng on 2018/3/21.
 */
public class RecoverBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2), left = new TreeNode(5), right = new TreeNode(1);
        //root.left = left;
        root.right = right;
//        right.left = new TreeNode(6);
//        right.right = new TreeNode(20);
        recoverTree(root);
    }

    public static void recoverTree(TreeNode root) {
        helper(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
        int a = 1;
    }

    static TreeNode first = null, second = null, prev = null;

    public static void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (prev != null && prev.val >= root.val) {
            if (first == null) first = prev;
            second = root;
        }
        prev = root;
        helper(root.right);
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
