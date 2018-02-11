import java.util.ArrayList;

/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
 * <p/>
 * Example 1:
 * Input:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p/>
 * Target = 9
 * <p/>
 * Output: True
 * Example 2:
 * Input:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p/>
 * Target = 28
 * <p/>
 * Output: False
 * <p/>
 * Created by deng on 2018/2/11.
 */
public class TwoSumIVInputIsABST {

    public static void main(String[] args) {

    }

    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        inorder(root, list);
        if (list.size() < 2) return false;
        int i = 0, j = list.size() - 1;
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum < k) i++;
            else if (sum > k) j--;
            else {
                return true;
            }
        }
        return false;
    }

    public static void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
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
