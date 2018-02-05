/**
 * https://leetcode.com/problems/same-tree/description/
 * Given two binary trees, write a function to check if they are the same or not.
 * <p/>
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 * <p/>
 * <p/>
 * Example 1:
 * <p/>
 * Input:     1         1
 * / \       / \
 * 2   3     2   3
 * <p/>
 * [1,2,3],   [1,2,3]
 * <p/>
 * Output: true
 * Example 2:
 * <p/>
 * Input:     1         1
 * /           \
 * 2             2
 * <p/>
 * [1,2],     [1,null,2]
 * <p/>
 * Output: false
 * Example 3:
 * <p/>
 * Input:     1         1
 * / \       / \
 * 2   1     1   2
 * <p/>
 * [1,2,1],   [1,1,2]
 * <p/>
 * Output: false
 * Created by deng on 2018/2/5.
 */
public class SameTree {
    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
