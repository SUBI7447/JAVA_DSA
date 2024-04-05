// Count ways to reach the nth stair. The person can climb either 1 stair or 2 stairs at a time.

package DYNAMIC_PROGRAMMING.DP_PART_1;

public class Climbing_Stairs {

    public static int C_S_M(int num, int dp[]) {

        if (num == 1 || num == 2) {
            return num;
        }

        if (dp[num] != 0) {
            return dp[num];
        }

        return dp[num] = C_S_M(num - 1, dp) + C_S_M(num - 2, dp);

    }

    public static int C_S_T(int num) {

        int dp[] = new int[num + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= num; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];

        }

        return dp[num];

    }

    public static void main(String[] args) {

        int num = 10;

        for (int i = 3; i < num; i++) {

            int dp[] = new int[num + 1];
            System.out.println(C_S_M(i, dp));
            System.out.println(C_S_T(i));

        }

    }

}
