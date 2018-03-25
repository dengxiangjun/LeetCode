import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/question/next?pid=6910869&qid=126949&tid=14482144
 * Created by deng on 2018/3/25.
 */
public class 字符串碎片 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
//        int k = sc.nextInt();
//        int n = 7, k = 3;
        //String s = "aaabbaaacd";
        double res = solve(s);
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(res));
    }

    public static double solve(String s) {
        int res = 1;
        int i = 0, j = 0;
        while (j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) j++;
            else {
                res++;
                i = j;
                j++;
            }
        }
        return (double) s.length() / res;
    }
}
