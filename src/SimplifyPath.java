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
        String res = simplifyPath("//a//c/b../");
        System.out.println(res);
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        int j = -1;
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == '/') {
                if (j > -1) {
                    stack.push(path.substring(j,i));
                    j = -1;
                }
                continue;
            } else if (c == '.') {
                if (j > -1) {
                    stack.push(path.substring(j,i));
                    j = -1;
                }
                if (i + 1 < path.length() && path.charAt(i + 1) == '.')
                    stack.pop();
                i++;
            } else {
                if (j == -1) j = i;
            }
        }
        String res = "/";
        for (int i =0;i<stack.size();i++)  res += stack.get(i) + "/";
        return res;
    }
}
