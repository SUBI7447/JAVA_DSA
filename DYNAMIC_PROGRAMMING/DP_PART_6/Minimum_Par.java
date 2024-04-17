package DYNAMIC_PROGRAMMING.DP_PART_6;

public class Minimum_Par {

    public static int M_P(int num[]) {

        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }

        int W = sum / 2;
        int dp[][] = new int[num.length + 1][W+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= W; j++) {

                if (num[i - 1] <= j) {

                    int a1 = dp[i - 1][j - num[i - 1]] + num[i - 1];
                    int a2 = dp[i - 1][j];
                    dp[i][j] = Math.max(a1, a2);

                } else {
                    dp[i][j] = dp[i - 1][j];

                }

            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <W; j++) {
                System.out.print(dp[i][j] + " ");

            }
            System.out.println();
        }
        int sum1 = dp[num.length][W];
        int sum2 = sum - sum1;

        return Math.abs(sum1 - sum2);

    }

    public static void main(String[] args) {
        int num[] = { 1, 6, 11, 5 };

        System.out.println(M_P(num));

    }

}
