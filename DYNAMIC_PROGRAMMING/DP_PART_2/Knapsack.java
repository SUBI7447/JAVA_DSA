package DYNAMIC_PROGRAMMING.DP_PART_2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Knapsack {

    public static int KS_(int val[], int wt[], int W, int n) {

        if (n == -1 || W == 0) {
            return 0;
        }

        if (W >= wt[n]) {

            int ans1 = val[n] + KS_(val, wt, W - wt[n], n - 1);

            int ans2 = KS_(val, wt, W, n - 1);

            return Math.max(ans1, ans2);
        } else {
            return KS_(val, wt, W, n - 1);
        }

    }

    public static int KS_M(int val[], int wt[], int W, int n, int dp[]) {

        if (n == -1 || W == 0) {
            return 0;
        }

        if (W >= wt[n]) {

            int ans1 = val[n] + KS_(val, wt, W - wt[n], n - 1);

            int ans2 = KS_(val, wt, W, n - 1);

            return Math.max(ans1, ans2);
        } else {
            return KS_(val, wt, W, n - 1);
        }

    }

    public static void main(String[] args) {

        int val[] = { 15, 14, 10, 45, 30 };

        int wt[] = { 2, 5, 1, 3, 4 };

        int W = 7;

        int dp[] = new int[val.length];
        Arrays.fill(dp, -1);

        System.out.println(KS_(val, wt, W, val.length - 1));
    }

}
