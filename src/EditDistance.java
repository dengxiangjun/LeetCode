/**
 * https://leetcode.com/problems/edit-distance/description/
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * <p/>
 * You have the following 3 operations permitted on a word:
 * <p/>
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * Created by deng on 2018/3/8.
 */
public class EditDistance {

    public static void main(String[] args) {
        int res = minDistance("ab", "a");
        System.out.println(res);
    }

    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) dp[i][0] = i;
        for (int i = 0; i <= word2.length(); i++) dp[0][i] = i;

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = dp[i - 1][j - 1] + 1;//替换操作
                dp[i][j] = Math.min(dp[i][j], Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));

//                // 增加操作：str1a变成str2后再加上b，得到str2b
//                int insertion = dp[i][j-1] + 1;
//                // 删除操作：str1a删除a后，再由str1变为str2b
//                int deletion = dp[i-1][j] + 1;
//                // 替换操作：先由str1变为str2，然后str1a的a替换为b，得到str2b
//                int replace = dp[i-1][j-1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);
//                // 三者取最小
//                dp[i][j] = Math.min(replace, Math.min(insertion, deletion));
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
