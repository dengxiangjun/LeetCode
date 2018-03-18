import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/restore-ip-addresses/description/
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * For example:
 * Given "25525511135",
 * <p>
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * Created by admin on 2018/3/18.
 */
public class RestoreIPAddresses {

    public static void main(String[] args) {
        List<String> res = restoreIpAddresses("010010");
        System.out.println(res);
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() < 4 && s.length() > 12) return res;
        List<String> item = new ArrayList<String>();
        backtrack(s, 0, item, res);
        return res;
    }

    public static void backtrack(String s, int index, List<String> item, List<String> res) {
        if (index == s.length() && item.size() == 4) {
            res.add(String.join(".", item));
            return;
        }
        if (index == s.length() || item.size() == 4) return;
        for (int i = 1; i <= 3 && index + i <= s.length(); i++) {
            String subStr = s.substring(index, index + i);
            int value = Integer.valueOf(subStr);
            if (i == 1 || (i == 2 && value >= 10 || (i == 3 && value >= 100 && value < 256))) {
                item.add(subStr);
                backtrack(s, index + i, item, res);
                item.remove(item.size() - 1);
            }
        }
    }
}
