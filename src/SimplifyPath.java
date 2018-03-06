import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/simplify-path/description/
 * Given an absolute path for a file (Unix-style), simplify it.
 * <p>
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * Created by deng on 2018/3/5.
 */
public class SimplifyPath {

    public static void main(String[] args) {
        String res = simplifyPath("/a/./b/../../c/");
        System.out.println(res);
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] p = path.split("/");
        for (int i = 0; i < p.length; i++) {
            String s = p[i];
            if (s.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!s.equals(".") && !s.equals("") && !s.equals("..")) stack.push(s);
        }
        List<String> list = new ArrayList(stack);
        return "/" + String.join("/", list);
    }
}
