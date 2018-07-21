import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/path-sum-iii/description/
 * You are given a binary tree in which each node contains an integer value.
 * <p>
 * Find the number of paths that sum to a given value.
 * <p>
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * <p>
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * <p>
 * Example:
 * <p>
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * <p>
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * <p>
 * Return 3. The paths that sum to 8 are:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class PathSumIII {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10), left = new TreeNode(5), right = new TreeNode(-3);
        root.left = left;
        root.right = right;

        left.left = new TreeNode(3);
        left.right = new TreeNode(2);

        left.left.left = new TreeNode(3);
        left.left.right = new TreeNode(-2);

        left.right.right = new TreeNode(1);

        right.right = new TreeNode(-1);
        right.right.right = new TreeNode(11);
        int res = pathSum(root, 8);
        System.out.println(res);
    }

//    /**
//     * 层次遍历+DFS
//     * @param root
//     * @param sum
//     * @return
//     */
//    public static int pathSum(TreeNode root, int sum) {
//        if (root == null) return 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        int[] res = new int[1];
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            TreeNode cur = queue.poll();
//            dfs(cur, sum, res);
//            if (cur.left != null) {
//                queue.offer(cur.left);
//            }
//            if (cur.right != null) {
//                queue.offer(cur.right);
//            }
//        }
//        return res[0];
//    }
//    public static void dfs(TreeNode root, int sum, int[] res) {
//        if (root == null) return;
//        sum -= root.val;
//        if (sum == 0) res[0]++;
//        if (root.left != null) dfs(root.left,sum,res);
//        if (root.right != null) dfs(root.right,sum,res);
//    }

    /**
     * 双DFS
     *
     * @param root
     * @param sum
     * @return
     */
    public static int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public static int dfs(TreeNode root, int sum) {
        int res = 0;
        if (root == null) return res;
        sum -= root.val;
        if (sum == 0) res++;
        if (root.left != null) res += dfs(root.left, sum);
        if (root.right != null) res += dfs(root.right, sum);
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
