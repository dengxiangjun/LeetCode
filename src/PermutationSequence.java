/**
 * https://leetcode.com/problems/permutation-sequence/description/
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * <p/>
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * <p/>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p/>
 * Note: Given n will be between 1 and 9 inclusive.
 * Created by deng on 2018/3/1.
 */
public class PermutationSequence {

    static int cnt;
    static String res;

    public static void main(String[] args) {
        String s = getPermutation(3, 6);
        System.out.println(s);
    }

    public static String getPermutation(int n, int k) {
        int[] a = new int[n];
        for (int i = 1; i <= n; i++) a[i - 1] = i;
        cnt = k;
        res = "";
        dfs(a, 0);
        return res;
    }

    public static void dfs(int[] a, int index) {
        if (index >= a.length) {
            cnt--;
            if (cnt == 0) {
                for (int i = 0; i < a.length; i++) res += a[i];
            }
            return;
        }

        for (int i = index; i < a.length; i++) {
            int tmp = a[i];
            a[i] = a[index];
            a[index] = tmp;
            dfs(a, index + 1);
            tmp = a[i];
            a[i] = a[index];
            a[index] = tmp;
        }
    }
}
