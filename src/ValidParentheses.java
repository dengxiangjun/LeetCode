import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p/>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * <p/>
 * <p/>
 * Created by deng on 2018/1/21.
 */
public class ValidParentheses {

    public static void main(String[] args) {
        String s = "()[]{";
        boolean result = isValid(s);
        System.out.println(result);
    }

    public static boolean isValid(String s) {
        if (s == null || "".equals(s)) return true;
        char[] ch = s.toCharArray();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = ch[i];
            if (c == '(' || c == '{' || c == '[') stack.push(c);
            else {
                if (stack.size() == 0) return false;
                char c1 = stack.pop();
                if (map.get(c1) != c) return false;
            }
        }
        return stack.size() == 0;
    }
}
