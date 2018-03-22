import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p/>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * Created by admin on 2018/3/22.
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10), left = new TreeNode(5), right = new TreeNode(15);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(1);
        left.right = new TreeNode(9);
        right.left = new TreeNode(6);
        right.right = new TreeNode(20);
        List<List<Integer>> res = zigzagLevelOrder(root);
        System.out.println(res);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int height = 0;
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
            if (height % 2 == 1) Collections.reverse(levelList);
            res.add(levelList);
            height++;
        }
        return res;
    }

//    public static void dfs(List<List<Integer>> res, TreeNode root, int height) {
//        if (root == null) return;
//        if (height >= res.size()) {
//            res.add(new ArrayList<Integer>());
//        }
//        res.get(height).add(root.val);
//        if (height % 2 == 0) {
//            dfs(res, root.right, height + 1);
//            dfs(res, root.left, height + 1);
//        } else {
//            dfs(res, root.left, height + 1);
//            dfs(res, root.right, height + 1);
//        }
//    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
