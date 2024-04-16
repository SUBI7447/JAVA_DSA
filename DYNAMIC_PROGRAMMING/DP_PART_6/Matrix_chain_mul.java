package DYNAMIC_PROGRAMMING.DP_PART_6;

public class Matrix_chain_mul {

    public static int MCM(int arr[], int i, int j) {

        if (i == j) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {

            int cost1 = MCM(arr, i, k);
            int cost2 = MCM(arr, k + 1, j);
            int cost3 = arr[i - 1] * arr[k] * arr[j];

            int final_cost = cost1 + cost2 + cost3;

            ans = Math.min(ans, final_cost);
        }

        return ans;
    }

    public static int MCM_M(int arr[], int i, int j, int dp[][]) {

        if (i == j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {

            int cost1 = MCM_M(arr, i, k, dp);
            int cost2 = MCM_M(arr, k + 1, j, dp);
            int cost3 = arr[i - 1] * arr[k] * arr[j];

            int final_cost = cost1 + cost2 + cost3;

            ans = Math.min(ans, final_cost);
        }

        return dp[i][j] = ans;
    }

    public static int MCM_T(int arr[]) {

        int dp[][] = new int[arr.length][arr.length];

        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 0;

        }

        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j <= dp.length - i; j++) {

                dp[j][j + i - 1] = Integer.MAX_VALUE;

            }
        }

        for (int len = 2; len < dp.length; len++) {

            for (int i = 1; i <= dp.length - len; i++) {

                int j = i + len - 1;

                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k <= j - 1; k++) {

                    int cost1 = dp[i][k];
                    int cost2 = dp[k + 1][j];
                    int cost3 = arr[i - 1] * arr[k] * arr[j];

                    dp[i][j] = Math.min(dp[i][j], cost1 + cost2 + cost3);
                }

            }

        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[1][arr.length - 1];

    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 3 };

        System.out.println(MCM(arr, 1, arr.length - 1));

        int dp[][] = new int[arr.length][arr.length];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(MCM_M(arr, 1, arr.length - 1, dp));

        System.out.println(MCM_T(arr));
    }

}
