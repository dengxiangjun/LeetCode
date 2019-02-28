import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        num *= 2;
        for (int i = 2; i < num; i++) {
            if (num % i == 0 && (num / i + 1 - i) % 2 == 0) {
                int start = (num / i + 1 - i) / 2;
                int end = start + i - 1;
                if (start <= 0) break;
                List<Integer> item = new ArrayList<Integer>();
                for (int j = start; j <= end; j++) item.add(j);
                list.add(item);
            }
        }
        if (list.size() == 0) System.out.println("NULL");

        for (int k = list.size() - 1; k >= 0; k--) {
            List<Integer> item = list.get(k);
            System.out.print("[");
            for (int i = 0; i < item.size(); i++) {
                if (i == item.size() - 1) System.out.print(item.get(i) + "]");
                else System.out.print(item.get(i) + ",");
            }
            System.out.println();
        }

    }


}
