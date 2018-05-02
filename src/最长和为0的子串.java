import java.util.HashMap;

/**
 * https://blog.csdn.net/u013807437/article/details/48738457
 * 输入：int 型数组由正数、负数、0组成
 * <p/>
 * 输出：最长和为0的子序列
 * <p/>
 * <p/>
 * <p/>
 * 例：
 * <p/>
 * 输入：[3,0,-1,-2,-3,1,1,1,2,3,1,-2,-1]
 * <p/>
 * 输出：9
 * Created by deng on 2018/5/2.
 */
public class 最长和为0的子串 {

    public static void main(String[] args) {
        int[] a = {3, 0, -1, -2, -3, 1, 1, 1, 2, 3, 1, -2, -1};
        int res = solve(a);
        System.out.println(res);
    }

    public static int solve(int[] a) {
        if (a == null || a.length == 0) return 0;

        int[] dp = new int[a.length];
        dp[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            dp[i] = a[i] + dp[i - 1];
        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            int begin = map.containsKey(dp[i]) ? map.get(dp[i]) : 0;
            if (begin == 0) map.put(dp[i], i);
            else {
                res = Math.max(res, i - begin + 1);
            }
        }
        return res;
    }
}
