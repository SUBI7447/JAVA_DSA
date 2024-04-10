package DYNAMIC_PROGRAMMING.DP_PART_2;

public class TargerSum {

    public static boolean TS_T(int nums[], int tar) {

        boolean dp[][] = new boolean[nums.length + 1][tar + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;

        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {

                if (nums[i - 1] <= j && dp[i - 1][j - nums[i - 1]] == true) {

                    dp[i][j] = true;

                } else if (dp[i - 1][j] == true) {
                    dp[i][j] = true;

                }

            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {

                if (dp[i][j]) {

                    System.out.print(" t ");
                } else {

                    System.out.print(" f ");
                }

            }
            System.out.println();
        }

        return false;
    }

    public static void main(String[] args) {

        int nums[] = { 4, 2, 7, 1, 3 };

        int tar = 10;

        System.out.println(TS_T(nums, tar));

    }
}
