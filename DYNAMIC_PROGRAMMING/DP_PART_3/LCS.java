// A subsequence of a string is a new string generated from the original string with some characters (can be none)
// deleted without changing the relative order of the remaining characters.

package DYNAMIC_PROGRAMMING.DP_PART_3;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LCS {

    public static int LCS_rec(String strl, String str2, int n, int m) {

        if (n == 0 || m == 0) {
            return 0;
        }
        if (strl.charAt(n - 1) == str2.charAt(m - 1)) {

            return 1 + LCS_rec(strl, str2, n - 1, m - 1);
        } else {

            return Math.max(LCS_rec(strl, str2, n, m - 1), LCS_rec(strl, str2, n - 1, m));
        }

    }

    public static int LCS_M(String strl, String str2, int n, int m, int dp[][]) {

        if (n == 0 || m == 0) {
            return dp[n][m] = 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (strl.charAt(n - 1) == str2.charAt(m - 1)) {

            return dp[n][m] = 1 + LCS_M(strl, str2, n - 1, m - 1, dp);
        } else {

            return dp[n][m] = Math.max(LCS_M(strl, str2, n, m - 1, dp), LCS_M(strl, str2, n - 1, m, dp));
        }

    }

    public static int LCS_T(String strl, String str2) {

        int n = strl.length();
        int m = str2.length();

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i < dp.length; i++) {

            for (int j = 1; j < dp[i].length; j++) {

                if (strl.charAt(i - 1) == str2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int a1 = dp[i][j - 1];
                    int a2 = dp[i - 1][j];
                    dp[i][j] = Math.max(a1, a2);
                }

            }

        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {

                if (dp[i][j] < 0) {
                    System.out.print(dp[i][j] + "  ");

                } else {

                    System.out.print(" " + dp[i][j] + "  ");

                }
            }
            System.out.println();
        }

        return dp[n][m];

    }

    public static void main(String[] args) {

        String strl = "abcdge";
        String str2 = "abedg";
        System.out.println(LCS_rec(strl, str2, strl.length(), str2.length()));

        int dp[][] = new int[strl.length() + 1][str2.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(LCS_M(strl, str2, strl.length(), str2.length(), dp));

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {

                if (dp[i][j] < 0) {
                    System.out.print(dp[i][j] + "  ");

                } else {

                    System.out.print(" " + dp[i][j] + "  ");

                }
            }
            System.out.println();
        }
        System.out.println();

        System.out.println(LCS_T(strl, str2));

    }

}
