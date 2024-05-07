package DYNAMIC_PROGRAMMING.DP_PART_6;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Min_Arr_Jump {

    public static int M_J(int arr[]) {

        int dp[] = new int[arr.length];

        Arrays.fill(dp, -1);

        dp[arr.length-1]=0;

        for (int i = arr.length - 2; i >= 0; i--) {

            int ans = Integer.MAX_VALUE;

            for (int j = i + 1; j <= i + arr[i] && j < arr.length; j++) {

                if (dp[j] != -1) {

                    ans = Math.min(ans, dp[j] + 1);

                }

            }

            if (ans != Integer.MAX_VALUE) {
                dp[i] = ans;
            }

        }

        return dp[0];

    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 1, 1, 4 };

        System.out.println(M_J(arr));
    }

}
