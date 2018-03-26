import java.util.Scanner;

/**
 * https://www.nowcoder.com/question/next?pid=6910869&qid=126949&tid=14482144
 * Created by deng on 2018/3/25.
 */
public class 魔法币 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int n = 7, k = 3;
        String res = solve(n);
        System.out.println(res);
    }

    public static String solve(int n) {
        StringBuffer sb = new StringBuffer();
        while (n > 0) {
            if (n % 2 == 0) {
                sb.append('2');
                n = (n-2)/2;
            }else {
                sb.append('1');
                n = (n-1)/2;
            }
        }
        return sb.reverse().toString();
    }
}
