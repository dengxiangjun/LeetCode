import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 * Given a binary tree, find the maximum path sum.
 * <p>
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 * <p>
 * For example:
 * Given the below binary tree,
 * <p>
 * 1
 * / \
 * 2   3
 * Return 6.
 * <p>
 * <p>
 * Created by deng on 2018/3/31.
 */
public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10), left = new TreeNode(5), right = new TreeNode(15);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(1);
        left.right = new TreeNode(9);
        right.left = new TreeNode(6);
        right.right = new TreeNode(20);
        int res = maxPathSum(root);
        System.out.println(res);
    }


    public static int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int[] max = {Integer.MIN_VALUE};
        int res = postOrder(root, max);
        return max[0];
    }

    /**
     * 后序遍历
     * @param root
     * @param max
     * @return
     */
    public static int postOrder(TreeNode root, int[] max) {
        if (root == null) return 0;
        int left = Math.max(0, postOrder(root.left,max));
        int right = Math.max(0, postOrder(root.right, max));
        max[0] = Math.max(max[0], left + right + root.val);
        return Math.max(left, right) + root.val;
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
