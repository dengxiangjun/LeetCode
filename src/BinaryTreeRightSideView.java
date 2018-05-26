import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * <p/>
 * Example:
 * <p/>
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 * <p/>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * Created by deng on 2018/5/26.
 */
public class BinaryTreeRightSideView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10), left = new TreeNode(5), right = new TreeNode(15);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(1);
        left.right = new TreeNode(9);
        right.left = new TreeNode(6);
        right.right = new TreeNode(20);
        List<Integer> res = rightSideView(root);

        System.out.println(res);
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            for (int i = cnt; i > 0; i--) {
                TreeNode cur = queue.poll();
                if (i == 1) res.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
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
