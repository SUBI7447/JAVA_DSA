// Given two strings wordl and word2, return the minimum number of operations required to convert wordl to
// word2.
// You have the following three operations permitted on a word:
// • Insert a character
// • Delete a character
// • Replace a character

package DYNAMIC_PROGRAMMING.DP_PART_4;

public class Edit_Dis {

    public static int Edit_D(String str1, String str2) {

        int dp[][] = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {

                    int add = dp[i - 1][j] + 1;
                    int del = dp[i][j - 1] + 1;
                    int rep = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(add, Math.min(del, rep));
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {

                if (dp[i][j] <= 9) {

                    System.out.print("0" + dp[i][j] + " ");
                } else {
                    System.out.print(dp[i][j] + " ");

                }

            }
            System.out.println();
        }

        return dp[str1.length()][str2.length()];

    }

    public static void main(String[] args) {

        String str1 = "intention";
        String str2 = "execution";

        System.out.println(Edit_D(str1, str2));

    }

}
