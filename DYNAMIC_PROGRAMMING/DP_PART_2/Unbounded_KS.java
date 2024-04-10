package DYNAMIC_PROGRAMMING.DP_PART_2;

public class Unbounded_KS {

    public static int U_KS_T(int val[], int wt[], int cap) {

        int dp[][] = new int[val.length + 1][cap + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {

                if (wt[i - 1] <= j) {

                    dp[i][j] = Integer.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
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

        return dp[val.length][cap];
    }

    public static void main(String[] args) {

        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };

        int cap = 7;

        System.out.println(U_KS_T(val, wt, cap));

    }

}
