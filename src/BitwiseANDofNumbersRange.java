import java.util.Arrays;

/**
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/description/
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * <p/>
 * Example 1:
 * <p/>
 * Input: [5,7]
 * Output: 4
 * Example 2:
 * <p/>
 * Input: [0,1]
 * Output: 0
 * Created by deng on 2018/5/26.
 */
public class BitwiseANDofNumbersRange {

    public static void main(String[] args) {
        int m = 5, n = 7;
        int res = rangeBitwiseAnd(m, n);
        System.out.println(res);
    }

    /**
     * 考虑数据的二进制形式。

     对于整数m到n，在数值连续变化的过程中，它们的某些高位比特是相同的，而只有低位的比特连续变化。

     例如：

     整数：33，34，35，36

     它们的二进制形式是（为了简单，我们假设每个数值有8个bits）：

     33 : 00100001
     34 : 00100010
     35 : 00100011
     36 : 00100100
     不难看出，它们都具有00100xxx的形式，共同的高位比特是：00100。如果进行按位与运算(&)的话，这些高位是保持不变的。

     再看低位（低3位比特）。与运算之后的结果是000。

     由上面的分析，可以得到：

     为了得到它们与运算的结果，我们只需要找出区间[m, n]范围内所有数值的共同高比特位即可。

     又因为m和n是这些数中相差最大的，所以它俩拥有的共同高位比特也是最少的。

     所以计算中只需要用m和n即可。

     作者：floodliu
     链接：https://www.jianshu.com/p/ea0f6aa14ef4
     來源：简书
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param m
     * @param n
     * @return
     */
    public static int rangeBitwiseAnd(int m, int n) {
        if (m == 0) return 0;
        int offset = 0;
        while (m != n) {
            m >>= 1;
            n >>=1;
            offset++;//offset位使得m=n,即不相同的低位的个数
        }
        return m << offset;//低位用0填充
    }
}
