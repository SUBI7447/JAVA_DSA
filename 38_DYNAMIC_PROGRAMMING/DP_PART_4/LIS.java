package DYNAMIC_PROGRAMMING.DP_PART_4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class LIS {

    public static int LIS(int arr[]) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);

        }

        int sor[] = new int[arr.length];
        int x = 0;
        for (int num : set) {
            sor[x] = num;
            x++;
        }

        Arrays.sort(sor);

        int ans = 0;

        int dp[][] = new int[arr.length + 1][arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(sor[i] + " ");
        }
        System.out.println();

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {

                if (arr[i - 1] == sor[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[arr.length][arr.length];

    }

    public static void main(String[] args) {

        int arr[] = { 50, 3, 10, 7, 40, 80 };

        System.out.println(LIS(arr));

    }

}
