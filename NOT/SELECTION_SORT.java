import javax.sound.midi.SysexMessage;

public class SELECTION_SORT {

    public int numIdenticalPairs(int[] nums) {

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] == nums[j]) {
                    ans++;
                }

            }
        }

        return ans;
    }

    public static void Selection_s(int arr[]) {

        for (int i = 0; i < arr.length - 1; i++) {

            int min_index = i;

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[min_index] > arr[j]) {

                    min_index = j;

                }
                int temp = arr[i];
                arr[i] = arr[min_index];
                arr[min_index] = temp;

            }

        }

        for (int i = 0; i < arr.length; i++) {

            System.out.println(arr[i]);

        }

    }

    public static void main(String args[]) {

        int arr[] = { 123, 12, 13, 23, 44, 55, 66 };

        Selection_s(arr);

    }
}
