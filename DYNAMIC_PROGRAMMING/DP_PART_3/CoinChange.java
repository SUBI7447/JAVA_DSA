package DYNAMIC_PROGRAMMING.DP_PART_3;

public class CoinChange {

    public static int CC_T(int coins[], int sum) {

        int dp[][] = new int[coins.length + 1][sum + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;

        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 0;

        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {

                if (coins[i - 1] <= j) {

                    int a1 = dp[i ][j - coins[i - 1]] + dp[i - 1][j];

                    dp[i][j] = a1;

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

        return dp[coins.length][sum];
    }

    public static void main(String[] args) {

        int coins[] = { 1,2,3};

        int sum = 4;

        System.out.println(
                CC_T(coins, sum));

    }
}
