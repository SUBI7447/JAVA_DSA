import java.util.Scanner;

public class SUB_ARRAYS {

    public static void sub_arrays(int arr[]) {
        int sum = 0;
        int m_sum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int j2 = i; j2 <= j; j2++) {
                    sum = sum + arr[j2];
                    System.out.print(arr[j2] + " ");
                }
                if (m_sum < sum) {
                    m_sum = sum;

                }
                System.out.println(" ------ SUM : " + sum);
                sum = 0;

            }

        }
        System.out.println(" MAX SUM : "+ m_sum);

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int arr[] = { 1, -2, 6, -1, 3 };
        sub_arrays(arr);

    }

}
