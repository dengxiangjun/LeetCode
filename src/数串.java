import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/a6a656249f404eb498d16b2f8eaa2c60?tpId=85&&tqId=29898&rp=1&ru=/activity/oj&qru=/ta/2017test/question-ranking
 * 题目描述
 * 设有n个正整数，将他们连接成一排，组成一个最大的多位整数。
 * 如:n=3时，3个整数13,312,343,连成的最大整数为34331213。
 * 如:n=4时,4个整数7,13,4,246连接成的最大整数为7424613。
 * 输入描述:
 * 有多组测试样例，每组测试样例包含两行，第一行为一个整数N（N<=100），第二行包含N个数(每个数不超过1000，空格分开)。
 * 输出描述:
 * 每组数据输出一个表示最大的整数。
 * 示例1
 * 输入
 * <p>
 * 2
 * 12 123
 * 4
 * 7 13 4 246
 * 输出
 * <p>
 * 12312
 * 7424613
 * Created by deng on 2018/3/6.
 */
public class 数串 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> res = new ArrayList<String>();
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            String number = numberSequence(a);
            res.add(number);
        }

        for (String item : res) System.out.println(item);
    }

    public static String numberSequence(int[] a) {
        String res = "";
        int select = 0;
        for (int i = 3; i > 0; i--) {
            for (int j = 0; j < a.length; j++) {
                int bit = a[j] / (int) (Math.pow(10, i));

            }
        }
        return res;
    }
}
