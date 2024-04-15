package DYNAMIC_PROGRAMMING.DP_PART_5;

public class Catalan_num {

    public static int Catalan(int num, int dp[]) {

        if (num == 0 || num == 1) {
            return 1;
        }

        if (dp[num] != 0) {
            return dp[num];
        }

        int ans = 0;
        for (int i = 0; i < num; i++) {

            ans += Catalan(i, dp) * Catalan(num - i - 1, dp);

        }
        return dp[num] = ans;

    }

    public static int Catalan_T(int num) {

        if (num == 1 || num == 0) {
            return 1;
        }

        int dp[] = new int[num + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {

            for (int j = 0; j < i; j++) {

                dp[i] += dp[j] * dp[i - j - 1];

            }

        }

        return dp[num];

    }

    public static void main(String[] args) {

        for (int i = 0; i <= 10; i++) {

            int dp[] = new int[i + 1];

            System.out.println(Catalan_T(i));
        }

    }

}
