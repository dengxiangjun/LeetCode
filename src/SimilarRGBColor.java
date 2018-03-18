import java.util.List;

/**
 * https://leetcode.com/contest/weekly-contest-76/problems/similar-rgb-color/
 * In the following, every capital letter represents some hexadecimal digit from 0 to f.
 * <p>
 * The red-green-blue color "#AABBCC" can be written as "#ABC" in shorthand.  For example, "#15c" is shorthand for the color "#1155cc".
 * <p>
 * Now, say the similarity between two colors "#ABCDEF" and "#UVWXYZ" is -(AB - UV)^2 - (CD - WX)^2 - (EF - YZ)^2.
 * <p>
 * Given the color "#ABCDEF", return a 7 character color that is most similar to #ABCDEF, and has a shorthand (that is, it can be represented as some "#XYZ"
 * <p>
 * Example 1:
 * Input: color = "#09f166"
 * Output: "#11ee66"
 * Explanation:
 * The similarity is -(0x09 - 0x11)^2 -(0xf1 - 0xee)^2 - (0x66 - 0x66)^2 = -64 -9 -0 = -73.
 * This is the highest among any shorthand color.
 * Note:
 * <p>
 * color is a string of length 7.
 * color is a valid RGB color: for i > 0, color[i] is a hexadecimal digit from 0 to f
 * Any answer which has the same (highest) similarity as the best answer will be accepted.
 * All inputs and outputs should use lowercase letters, and the output is 7 characters.
 * Discuss
 * <p>
 * <p>
 * Created by admin on 2018/3/18.
 */
public class SimilarRGBColor {

    public static void main(String[] args) {
        String s = "#09f166";
        String res = similarRGB(s);
        System.out.println(res);
    }

    public static String similarRGB(String color) {
        int[] hash = {0x00,0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, 0x88, 0x99, 0xAA, 0xBB, 0xCC, 0xDD, 0xEE, 0xFF};
        int[] a = new int[3];
        for (int i = 1; i <= 5; i += 2) {
            String s = color.substring(i,i+2);
            a[(i - 1) / 2] = Integer.valueOf(s,16);
        }

        String res = "#";
        for (int i = 0; i < 3; i++) {
            int min = Integer.MAX_VALUE;
            String subStr = "";
            for (int j = 0; j < hash.length; j++) {
                int diff = (a[i] - hash[j]) * (a[i] - hash[j]);
                if (diff < min) {
                    min = diff;
                    subStr = Integer.toHexString(hash[j]);
                    if (subStr.length() == 1) subStr+=subStr;
                }
            }
            res += subStr;
        }
        return res;
    }
}
