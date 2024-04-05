package DYNAMIC_PROGRAMMING.DP_PART_1;

public class DP_Ways {

    public static int fib_using_memorization(int arr[], int num) {

        if (num == 0 || num == 1) {
            return num;
        }

        if (arr[num] != 0) {
            return arr[num];
        }

        arr[num] = fib_using_memorization(arr, num - 1) + fib_using_memorization(arr, num - 2);
        return arr[num];
    }

    public static int fib_using_tabulation(int num) {

        int dp[] = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= num; i++) {

            dp[i] = dp[i - 1] + dp[i - 2];

        }
        return dp[num];
    }

    public static void main(String[] args) {



        for (int i = 2; i < 10; i++) {
            
        int arr[] = new int[i + 1];
        System.out.println(fib_using_memorization(arr, i));
        System.out.println(fib_using_tabulation(i));
        }

    }

}
