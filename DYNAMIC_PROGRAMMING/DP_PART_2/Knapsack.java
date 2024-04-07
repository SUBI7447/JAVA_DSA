package DYNAMIC_PROGRAMMING.DP_PART_2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Knapsack {

    // public static int KS_(int val[], int wt[], int W, int n) {

    // if (n == -1 || W == 0) {
    // return 0;
    // }

    // if (W >= wt[n]) {

    // int ans1 = val[n] + KS_(val, wt, W - wt[n], n - 1);

    // int ans2 = KS_(val, wt, W, n - 1);

    // return Math.max(ans1, ans2);
    // } else {
    // return KS_(val, wt, W, n - 1);
    // }

    // }

    public static int KS_M(int val[], int wt[], int W, int n, int dp[][]) {

        if (n == -1 || W == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {

            return dp[n][W];
        }

        if (W >= wt[n]) {

            int ans1 = val[n] + KS_M(val, wt, W - wt[n], n - 1, dp);

            int ans2 = KS_M(val, wt, W, n - 1, dp);

            return dp[n][W] = Math.max(ans1, ans2);
        } else {
            return dp[n][W] = KS_M(val, wt, W, n - 1, dp);
        }

    }

    public static int KS_T(int val[], int wt[], int W) {

        int n = val.length;

        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                int v = val[i - 1];
                int w = wt[i - 1];
                if (w <= j) {

                    int incProfit = v + dp[i - 1][j - w];
                    int excProfit = dp[i - 1][j];

                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        return dp[n][W];

    }

    public static void main(String[] args) {

        int val[] = { 15, 14, 10, 45, 30 };

        int wt[] = { 2, 5, 1, 3, 4 };

        int W = 7;

        int dp[][] = new int[val.length][W + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;

            }
        }

        System.out.println(KS_M(val, wt, W, val.length - 1, dp));
        System.out.println(KS_T(val, wt, W));

    }

}
