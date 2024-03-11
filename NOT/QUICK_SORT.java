public class QUICK_SORT {

    public static void main(String args[]) {

        int arr[] = { 1, 3, 7, 2, 0, 1, 7, 1, 3, 8 };

        quicksort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }
    }

    public static void quicksort(int arr[], int si, int ei) {

        if (si>=ei) {
            return;
            
        }

        int p = partation(arr, si, ei);

        quicksort(arr, si, p - 1);
        quicksort(arr, p + 1, ei);

    }

    public static int partation(int arr[], int si, int ei) {

        int p = arr[ei];
        int i = si - 1;

        for (int j = si; j < ei; j++) {

            if (arr[j] <= p) {
                i++;

                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;

            }

        }

        i++;

        int temp = p;
        arr[ei] = arr[i];
        arr[i] = temp;

        return i;

    }

}
