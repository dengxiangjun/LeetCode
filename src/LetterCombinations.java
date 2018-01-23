import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by deng on 2018/1/20.
 */
public class LetterCombinations {
    static Map<Integer, char[]> map = new HashMap<Integer, char[]>();
    static List<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        String digits = "23";
        List<String> result = letterCombinations(digits);
        for (String s : result) System.out.println(s);
    }

    public static List<String> letterCombinations(String digits) {
        // Map<Integer, char[]> map = new HashMap<Integer, char[]>();
        char[] c2 = {'a', 'b', 'c'}, c3 = {'d', 'e', 'f'}, c4 = {'g', 'h', 'i'}, c5 = {'j', 'k', 'l'}, c6 = {'m', 'n', 'o'}, c7 = {'p', 'q', 'r', 's'},
                c8 = {'t', 'u', 'v'}, c9 = {'w', 'x', 'y', 'z'};
        map.put(2, c2);
        map.put(3, c3);
        map.put(4, c4);
        map.put(5, c5);
        map.put(6, c6);
        map.put(7, c7);
        map.put(8, c8);
        map.put(9, c9);
        char[] ch = new char[digits.length()];
        letterCombinations(digits, 0, ch);
        return list;
    }

    public static void letterCombinations(String digits, int index, char[] ch) {
        if (index == digits.length()) {
            String tmp = new String(ch);
            list.add(tmp);
            return;
        }
        char[] ci = map.get(digits.charAt(index) - '0');
        for (int i = 0; i < ci.length; i++) {
            ch[index] = ci[i];
            letterCombinations(digits, index + 1, ch);
        }
    }
//    public static List<String> letterCombinations(String digits) {
//        Map<Integer, char[]> map = new HashMap<Integer, char[]>();
//        char[] c2 = {'a', 'b', 'c'}, c3 = {'d', 'e', 'f'}, c4 = {'g', 'h', 'i'}, c5 = {'j', 'k', 'l'}, c6 = {'m', 'n', 'o'}, c7 = {'p', 'q', 'r', 's'},
//                c8 = {'t', 'u', 'v'}, c9 = {'w', 'x', 'y', 'z'};
//        map.put(2, c2);
//        map.put(3, c3);
//        map.put(4, c4);
//        map.put(5, c5);
//        map.put(6, c6);
//        map.put(7, c7);
//        map.put(8, c8);
//        map.put(9, c9);
//
//        List<StringBuilder> list = new ArrayList<StringBuilder>();
//        char[] c = digits.toCharArray();
//        for (int i = 0; i < c.length; i++) {
//            int num = c[i] - '0';
//            char[] ci = map.get(num);
//            if (list.size() == 0) {
//                for (char cii : ci) list.add(new StringBuilder().append(cii));
//            }else {
//                List<StringBuilder> tmp = new ArrayList<StringBuilder>();
//                for (StringBuilder sb : list)
//                    for (char cii : ci){
//                        StringBuilder p = new StringBuilder(sb);
//                        tmp.add(p.append(cii));
//                    }
//                list = tmp;
//            }
//        }
//        List<String> list1 = new ArrayList<String>();
//        for (StringBuilder sb : list) list1.add(sb.toString());
//        return list1;
//    }


}
