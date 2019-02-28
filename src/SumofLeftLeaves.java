import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 * description Find the sum of all left leaves in a given binary tree.
 * <p>
 * Example:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 *
 * @author dengxiangjun@jd.com
 * @date 2018/12/21 14:14
 **/
public class SumofLeftLeaves {

//    /**
//     * 层次遍历
//     * @param root
//     * @return
//     */
//    public static int sumOfLeftLeaves(TreeNode root) {
//        if (root == null) return 0;
//        int res = 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            TreeNode cur = queue.poll();
//            if (cur.left != null) {
//                if (cur.left.left == null && cur.left.right == null) res += cur.left.val;
//                queue.add(cur.left);
//            }
//            if (cur.right != null) {
//                queue.add(cur.right);
//            }
//        }
//        return res;
//    }
}
