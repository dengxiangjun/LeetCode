import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * Created by admin on 2018/3/22.
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10), left = new TreeNode(5), right = new TreeNode(15);
        root.left = left;
        root.right = right;
        // left.left = new TreeNode(1);
        left.right = new TreeNode(9);
        right.left = new TreeNode(6);
        right.right = new TreeNode(20);
        List<List<Integer>> res = levelOrder(root);
        System.out.println(res);
    }

//    /**
//     * 手动统计当前层次和下一层的节点个数
//     * @param root
//     * @return
//     */
//    public static List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        if (root == null) return res;
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.add(root);
//        int curCnt = 1, nextCnt = 0;
//        List<Integer> levelList = new ArrayList<Integer>();
//
//        while (!queue.isEmpty()) {
//            TreeNode cur = queue.poll();
//            if (cur.left != null) {
//                queue.add(cur.left);
//                nextCnt++;
//            }
//            if (cur.right != null) {
//                queue.add(cur.right);
//                nextCnt++;
//            }
//            levelList.add(cur.val);
//            curCnt--;
//            if (curCnt == 0) {
//                res.add(levelList);
//                levelList = new ArrayList<Integer>();
//                curCnt = nextCnt;
//                nextCnt = 0;
//            }
//        }
//        return res;
//    }

    /**
     * 每次循环，队列中的元素个数就是下一层的节点个数
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
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
            res.add(levelList);
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
