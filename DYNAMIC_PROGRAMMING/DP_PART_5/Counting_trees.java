package DYNAMIC_PROGRAMMING.DP_PART_5;

public class Counting_trees {

    public static int CT(int num) {

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

        int n = 3;
    }

}
