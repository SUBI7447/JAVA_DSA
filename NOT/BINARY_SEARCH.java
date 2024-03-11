import java.util.*;

public class BINARY_SEARCH {

    public static int binary_s(int arr[], int key) {

        int st_i = 0;
        int ed_i = arr.length - 1;

        while (st_i <= ed_i) {

            int mid_i = (ed_i + st_i) / 2;

            if (arr[mid_i] == key) {
                return mid_i;

            }
            if (arr[mid_i] > key) {
                ed_i = mid_i - 1;

            }
            if (key > arr[mid_i]) {
                st_i = mid_i + 1;

            }

        }

        return -1;

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println(binary_s(arr, 60));

    }

}
