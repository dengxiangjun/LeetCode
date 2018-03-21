import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * <p/>
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * <p/>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * Created by deng on 2018/3/20.
 */
public class UniqueBinarySearchTreesII {

    public static void main(String[] args) {
        List<TreeNode> res = generateTrees(3);
        System.out.println(res);
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        List<TreeNode> res = backtrack(1, n);
        return res;
    }

    public static List<TreeNode> backtrack(int start, int end) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (start > end){
            res.add(null);
            return res;
        }

        for (int k = start; k <= end; k++) {
            List<TreeNode> leftChild = backtrack(start, k - 1);
            List<TreeNode> rightChild = backtrack(k + 1, end);
            for (int i = 0; i < leftChild.size(); i++)
                for (int j = 0; j < rightChild.size(); j++) {
                    TreeNode root = new TreeNode(k);
                    root.left = leftChild.get(i);
                    root.right = rightChild.get(j);
                    res.add(root);
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
