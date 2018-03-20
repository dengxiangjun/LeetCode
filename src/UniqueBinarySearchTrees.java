/**
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * <p/>
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * <p/>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * Created by admin on 2018/3/19.
 */
public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        int res = numTrees(3);
        System.out.println(res);
    }

    /**
     *
     * @param n
     * @return
     */
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 1; j <= i; j++)//j作为根节点
                dp[i] += dp[j - 1] * dp[i - j];//左边有j-1个结点，右边有i-j个结点，总共能构成dp[j - 1] * dp[i - j]颗树
        return dp[n];
    }
}
