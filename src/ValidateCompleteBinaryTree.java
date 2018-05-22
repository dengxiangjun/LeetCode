import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一棵树是否为完全二叉树
 * Created by deng on 2018/5/21.
 */
public class ValidateCompleteBinaryTree {

    /**
     * 如果已经出现了一个结点不是满结点，后面还有结点存在孩子的话，就不是完全二叉树
     *
     * @param root
     * @return
     */
    public static boolean isCompleteBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        boolean flag = false;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (flag) {
                if (cur.left != null || cur.right != null) return false;
            } else {
                if (cur.left != null && cur.right != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else if (cur.right != null) return false;
                else if (cur.left != null) {
                    queue.offer(cur.left);
                    flag = true;
                } else flag = true;
            }
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
