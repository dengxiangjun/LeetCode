import java.util.ArrayList;

/**
 * https://leetcode.com/problems/permutation-sequence/description/
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * <p>
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p>
 * Note: Given n will be between 1 and 9 inclusive.
 * Created by deng on 2018/3/1.
 */
public class PermutationSequence {

    public static void main(String[] args) {
        String s = getPermutation(3, 6);
        System.out.println(s);
    }

    public static String getPermutation(int n, int k) {
        int[] fib = new int[n];
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) a.add(i);
        fib[0] = 1;
        String res = "";
        for (int i = 1; i < n; i++) fib[i] = i * fib[i - 1];//i位数的全排列个数
        k--;
        for (int i = n; i > 0; i--) {
            int index = k / fib[i - 1];
            res += a.get(index);
            a.remove(index);
            k = k % fib[i - 1];
        }
        return res;
    }

}
