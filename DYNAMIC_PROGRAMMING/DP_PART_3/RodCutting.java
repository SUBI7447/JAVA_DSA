package DYNAMIC_PROGRAMMING.DP_PART_3;

public class RodCutting {

    public static int RodC_T(int len[], int pri[], int roll) {

        int dp[][] = new int[len.length + 1][roll + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {

                if (len[i - 1] <= j) {

                    dp[i][j] = Math.max(pri[i - 1] + dp[i][j - len[i - 1]], dp[i - 1][j]);

                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[len.length][roll];

    }

    public static void main(String[] args) {

        int len[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int pri[] = { 1, 5, 8, 9, 10, 17, 17, 20 };

        int roll = 8;

        System.out.println(RodC_T(len, pri, roll));

    }

}
