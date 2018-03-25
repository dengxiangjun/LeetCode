import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/question/next?pid=6910869&qid=126950&tid=14482144
 * Created by deng on 2018/3/25.
 */
public class 游历魔法王国 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n - 1];
        for (int i = 0; i < n - 1; i++) a[i] = sc.nextInt();
//        int n = 3, k = 2;
//         int[] a = {0, 0};
        int res = solve(n, k, a);
        System.out.println(res);
    }

    public static int solve(int n, int k, int[] a) {
        List<List<Integer>> path = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) path.add(new ArrayList<Integer>());
        for (int i = 0; i < a.length; i++) {
            List<Integer> to = path.get(i + 1), from = path.get(a[i]);
            to.add(a[i]);
            from.add(i + 1);
        }
        int[] max = new int[1];
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(k, 0, 1, max, visited, path);
        return max[0];
    }

    public static void dfs(int k, int city, int cnt, int[] max, boolean[] visited, List<List<Integer>> path) {
        if (k == 0) {
            max[0] = Math.max(max[0], cnt);
            return;
        }
        List<Integer> toList = path.get(city);
        for (int to : toList) {
            if (!visited[to]) {
                visited[to] = true;
                dfs(k - 1, to, cnt + 1, max, visited, path);
                visited[to] = false;
            }else {
                dfs(k - 1, to, cnt, max, visited, path);
            }
        }
    }
}
