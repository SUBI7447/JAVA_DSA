// Convert Stringl to String2 with only insertion & deletion.
// Print number of deletions & insertions.

package DYNAMIC_PROGRAMMING.DP_PART_4;

public class String_Conv {

    public static int SC(String str1, String str2) {

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
                    dp[i][j] = Math.min(add, del);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {

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

        String str1 = "pear";
        String str2 = "sea";

        System.out.println(SC(str1, str2));

    }

}
