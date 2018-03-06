import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/text-justification/description/
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 * <p>
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * <p>
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * <p>
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * <p>
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * <p>
 * Return the formatted lines as:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 * Created by deng on 2018/3/5.
 */
public class TextJustification {

    public static void main(String[] args) {
        String[] words = {"What", "must", "be", "shall", "be."};
        List<String> res = fullJustify(words, 12);
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        int index = 0;
        while (index < words.length) {
            int last = index + 1, count = words[index].length();
            while (last < words.length) {
                if (1 + count + words[last].length() > maxWidth) break;
                count += 1 + words[last].length();
                last++;
            }
            int diff = last - index - 1;
            StringBuilder builder = new StringBuilder();
            builder.append(words[index]);
            if (last == words.length || diff == 0) {//最后一行或者一行只有一个单词
                for (int i = index + 1; i < last; i++) //最后一行的每个单词处理
                    builder.append(" ").append(words[i]);
                for (int i = builder.length(); i < maxWidth; i++) //文本最后一行最末尾的空格填充
                    builder.append(" ");
            } else {
                int space = (maxWidth - count) / diff;
                int r = (maxWidth - count) % diff;
                for (int i = index + 1; i < last; i++) {
                    for (int k = space; k > 0; k--) builder.append(" ");
                    if (r > 0) {
                        builder.append(" ");
                        r--;
                    }
                    builder.append(" ").append(words[i]);
                }
            }
            index = last;
            res.add(builder.toString());
        }
        return res;
    }
}
