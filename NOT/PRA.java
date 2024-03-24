import java.util.*;

public class PRA {

    public static void numSquares(int n) {

        int Psqu[] = new int[316];

        int j = 0;

        for (int i = 0; i < Psqu.length; i++) {

            Psqu[i] = ++j * j;

        }

        for (int i = 0; i < Psqu.length; i++) {

            System.out.println(i + " " + Psqu[i]);
        }

    }

    public static void findDuplicate(int[] nums) {

        int arr[] = new int[nums.length];

        for (int i = 0; i < arr.length; i++) {

            System.out.println(arr[i] + " ");
        }
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {

            if (arr[nums[i]] == 1) {
                System.out.println(nums[i] + " appera twice ");
                ans = nums[i];
                break;
            } else {
                System.out.println(nums[i] + " apperas ");

                arr[nums[i]] = 1;
            }

        }

        System.out.println(ans);

    }

    public static void main(String[] args) {

        System.out.println("------");

        int nums[]={3,3,3,3,3};
        findDuplicate(nums);
    }
}
