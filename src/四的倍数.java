
import java.util.Scanner;

/**
 * https://www.nowcoder.com/question/next?pid=6910869&qid=126951&tid=14482144
 * Created by deng on 2018/3/25.
 */
public class 四的倍数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            int[] a = new int[k];
            for (int j = 0; j < k; j++) a[j] = sc.nextInt();
            boolean res = solve(a);
            System.out.println(res ? "Yes" : "No");
        }
    }

    public static boolean solve(int[] a) {
        int four = 0, two = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 4 == 0) four++;
            else if (a[i] % 2 == 0) two++;
        }
        int odd = a.length - four - two;
        if (odd > 0) return four >= odd;
        else return four >= (odd - 1);
    }
}
