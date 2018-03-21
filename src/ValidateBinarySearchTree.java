import java.util.Stack;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 * 2
 * / \
 * 1   3
 * Binary tree [2,1,3], return true.
 * Example 2:
 * 1
 * / \
 * 2   3
 * Binary tree [1,2,3], return false.
 * Created by deng on 2018/3/21.
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10), left = new TreeNode(5), right = new TreeNode(15);
        root.left = left;
        root.right = right;
        right.left = new TreeNode(6);
        right.right = new TreeNode(20);
        boolean res = isValidBST(root);
        System.out.println(res);
    }

//    /**
//     * 递归的方法
//     * @param root
//     * @return
//     */
//    public static boolean isValidBST(TreeNode root) {
//        return isValid(root, null, null);
//    }
//
//    public static boolean isValid(TreeNode root, Integer min, Integer max) {
//        if (root == null) return true;
//        if (min != null && root.val <= min) return false;
//        if (max != null && root.val >= max) return false;
//        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
//    }

    /**
     * 中序遍历的方法
     *
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        TreeNode pre = null, cur = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre != null && cur.val <= pre.val) return false;
            pre = cur;
            cur = cur.right;
        }
        return true;
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
