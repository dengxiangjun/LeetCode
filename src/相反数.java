import java.util.Scanner;

/**
 * https://www.nowcoder.com/question/next?pid=6910869&qid=126948&tid=14482144
 * Created by deng on 2018/3/25.
 */
public class 相反数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int n = 7, k = 3;
        int res = solve(n);
        System.out.println(res);
    }

    public static int solve(int n) {
        int tmp = n;
        int res = 0;
        while (tmp > 0) {
            int remain = tmp % 10;
            res = res * 10 + remain;
            tmp /=10;
        }
        return res + n;
    }
}
