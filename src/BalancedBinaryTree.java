import java.util.List;

/**
 * https://leetcode.com/problems/balanced-binary-tree/description/
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as:
 * <p>
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Example 1:
 * <p>
 * Given the following tree [3,9,20,null,null,15,7]:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Return true.
 * <p>
 * Example 2:
 * <p>
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * Return false.
 * Created by deng on 2018/3/23.
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10), left = new TreeNode(5), right = new TreeNode(15);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(1);
        left.right = new TreeNode(9);
        right.left = new TreeNode(6);
        right.right = new TreeNode(20);
        boolean res = isBalanced(root);
        System.out.println(res);
    }

    /**
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return depth(root) != -1;
    }

    /**
     * 使用-1代表不平衡的子树，大于等于0代表树的高度
     * @param root
     * @return
     */
    public static int depth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if (leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1) return -1;
        return 1 + Math.max(leftDepth, rightDepth);
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
