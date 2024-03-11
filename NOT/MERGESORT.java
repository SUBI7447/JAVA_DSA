public class MERGESORT {

    public static void main(String args[]) {

        int arr[] = { 1, 3, 7, 2, 0, 1, 7, 1, 3, 8 };

        merge_sort(arr, 0, arr.length-1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }
    }

    public static void merge_sort(int arr[], int si, int ei) {

        if (si >= ei) {
            return;

        }

        int mid = si + (ei - si) / 2;

        merge_sort(arr, si, mid);
        merge_sort(arr, mid + 1, ei);

        merge(arr, si, mid, ei);

    }

    public static void merge(int arr[], int si, int mid, int ei) {

        int temp[] = new int[ei - si + 1];

        int i = si;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= ei) {

            if (arr[i] < arr[j]) {

                temp[k] = arr[i];
                i++;
                k++;

            } else {
                temp[k] = arr[j];
                j++;
                k++;

            }

        }

        while (i<=mid) {
            temp[k++]=arr[i++];
            
        }
        while (j<=ei) {
            temp[k++]=arr[j++];
            
        }

        for ( k = 0,i=si; k < temp.length; k++,i++) {

            arr[i]=temp[k];
            
        }
    }

}
