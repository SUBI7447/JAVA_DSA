// Longest Common Substring
// a substring is a contiguous sequence of characters within a string

package DYNAMIC_PROGRAMMING.DP_PART_4;

public class LCSS {

    public static int LCSS_(String S1, String S2) {

        int dp[][] = new int[S1.length() + 1][S2.length() + 1];

        int ans = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {

                if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    ans = Math.max(dp[i][j], ans);
                }

            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return ans;

    }

    public static void main(String[] args) {
        String Sl = "ABCDGH";
        String S2 = "ACDGHR";

        System.out.println(LCSS_(Sl, S2));
    }

}
