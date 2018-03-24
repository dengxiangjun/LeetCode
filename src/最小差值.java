import java.util.Arrays;
import java.util.Scanner;

/**
 * http://118.190.20.162/view.page?gpid=T68
 * 问题描述
 * <p/>
 * 　　给定n个数，请找出其中相差（差的绝对值）最小的两个数，输出它们的差值的绝对值。
 * <p/>
 * 输入格式
 * <p/>
 * 　　输入第一行包含一个整数n。
 * 　　第二行包含n个正整数，相邻整数之间使用一个空格分隔。
 * <p/>
 * 输出格式
 * <p/>
 * 　　输出一个整数，表示答案。
 * <p/>
 * 样例输入
 * <p/>
 * 5
 * 1 5 4 8 20
 * <p/>
 * 样例输出
 * <p/>
 * 1
 * <p/>
 * 样例说明
 * <p/>
 * 　　相差最小的两个数是5和4，它们之间的差值是1。
 * <p/>
 * 样例输入
 * <p/>
 * 5
 * 9 3 6 1 3
 * <p/>
 * 样例输出
 * <p/>
 * 0
 * <p/>
 * 样例说明
 * <p/>
 * 　　有两个相同的数3，它们之间的差值是0.
 * <p/>
 * 数据规模和约定
 * <p/>
 * 　　对于所有评测用例，2 ≤ n ≤ 1000，每个给定的整数都是不超过10000的正整数。
 * Created by deng on 2018/3/24.
 */
public class 最小差值 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        Arrays.sort(a);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1;i++) diff = Math.min(diff, a[i + 1] - a[i]);
        System.out.println(diff);
    }
}
