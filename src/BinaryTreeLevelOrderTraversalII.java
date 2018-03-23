import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * <p/>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * <p/>
 * Created by deng on 2018/3/23.
 */
public class BinaryTreeLevelOrderTraversalII {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10), left = new TreeNode(5), right = new TreeNode(15);
        root.left = left;
        root.right = right;
        // left.left = new TreeNode(1);
        left.right = new TreeNode(9);
        right.left = new TreeNode(6);
        right.right = new TreeNode(20);
        List<List<Integer>> res = levelOrderBottom(root);
        System.out.println(res);
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSum = queue.size();
            List<Integer> levelList = new ArrayList<Integer>();
            for (int i = 0; i < levelSum; i++) {
                if (queue.peek().left != null) {
                    queue.add(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.add(queue.peek().right);
                }
                levelList.add(queue.poll().val);
            }
            res.add(0,levelList);
        }
        return res;
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
