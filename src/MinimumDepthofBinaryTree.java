/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Created by deng on 2018/3/23.
 */
public class MinimumDepthofBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10), left = new TreeNode(5), right = new TreeNode(15);
        root.left = left;
        root.right = right;
//        left.left = new TreeNode(1);
//        left.right = new TreeNode(9);
        right.left = new TreeNode(6);
        right.right = new TreeNode(20);
        int res = minDepth(root);
        System.out.println(res);
    }

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left != null && root.right != null) return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        if (root.left != null) return 1 + minDepth(root.left);
        return 1 + minDepth(root.right);
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
