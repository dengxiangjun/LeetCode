/**
 * Given a complete binary tree, count the number of nodes.
 * <p/>
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last,
 * is completely filled, and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 * Created by deng on 2018/2/5.
 */
public class CountCompleteTreeNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1), l1 = new TreeNode(2), l2 = new TreeNode(3), l11 = new TreeNode(4);
        root.left = l1;
        root.right = l2;
        l1.left = l11;
        int res = countNodes(root);
        System.out.println(res);
    }

    public static int countNodes(TreeNode root) {
        int leftH = 0, rightH = 0;
        TreeNode left = root, right = root;
        while (left != null) {
            leftH++;
            left = left.left;
        }
        while (right != null) {
            rightH++;
            right = right.right;
        }
        if (leftH == rightH) return (1 << leftH) - 1;//左子树结点个数与右子树结点个数相等，说明是满二叉树
        else return 1 + countNodes(root.left) + countNodes(root.right);//不是满二叉树
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
