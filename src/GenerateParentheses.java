import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/description/
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p/>
 * For example, given n = 3, a solution set is:
 * <p/>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * Created by deng on 2018/1/22.
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        int a = 1;
        List<String> result = generateParenthesis(a);
        for (String s : result)
            System.out.println(s);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generateParenthesis(n, n, "", res);
        return res;
    }

    public static void generateParenthesis(int left, int right, String out, List<String> res) {
        if (left < 0 || right < 0 || left > right) return;
        if (left == 0 && right == 0) {
            res.add(out);
            return;
        }
        generateParenthesis(left - 1, right, out + "(", res);
        generateParenthesis(left, right - 1, out + ")", res);
    }
}
