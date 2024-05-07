// Given a text and a wildcard pattern, implement wildcard pattern matching algorithm that finds if wildcard
// pattern is matched with text. The matching should cover the entire text (not partial text). The wildcard
// pattern can include the characters '?' and '*'
// • '? matches any single character
// • '*' - Matches any sequence of characters (including the empty sequence)

package DYNAMIC_PROGRAMMING.DP_PART_5;

public class Wildcard_matching {

    public static boolean WCM(String text, String pattern) {

        int n = text.length();
        int m = pattern.length();

        boolean dp[][] = new boolean[n + 1][m + 1];

        dp[0][0] = true;

        for (int i = 1; i < dp[0].length; i++) {
            if (pattern.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            } else {
                dp[0][i] = false;

            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {

                if (pattern.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (pattern.charAt(j - 1) == text.charAt(i - 1) || pattern.charAt(j - 1) == '?') {

                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[n][m];

    }

    public static void main(String[] args) {

        String text = "baaabab";
        String pattern = "*****ba*****ab";

        System.out.println(WCM(text, pattern));

    }

}
