import java.util.ArrayList;
import java.util.PriorityQueue;

public class heaps {

    static class student implements Comparable<student> {

        String name;
        int rank;

        public student(String name, int rank) {

            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(student s) {
            return this.rank - s.rank;
        }

    }

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {

            arr.add(data);

            int ch = arr.size() - 1;
            int par = (ch - 1) / 2;

            while (arr.get(ch) < arr.get(par)) {

                int temp = arr.get(ch);
                arr.set(ch, arr.get(par));
                arr.set(par, temp);

                ch = par;
                par = (ch - 1) / 2;

            }
        }

        public void heapify(int i) {

            int left = (i * 2) + 1;
            int right = (i * 2) + 2;
            int mid = i;

            if (left < arr.size() && arr.get(mid) > arr.get(left)) {
                mid = left;
            }

            if (right < arr.size() && arr.get(mid) > arr.get(right)) {
                mid = right;
            }

            if (mid != i) {

                int temp = arr.get(i);
                arr.set(i, arr.get(mid));
                arr.set(mid, temp);

                heapify(mid);

            }
        }

        public int delete() {

            int data = arr.get(0);

            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            arr.remove(arr.size() - 1);

            heapify(0);

            return data;

        }

        public boolean isEMP() {

            return arr.size() == 0;

        }

        public static void heap_sort(int arr[]) {

            int n = arr.length;

            for (int i = n / 2; i >= 0; i--) {

                Heapify_arr(arr, i, n);

            }

            for (int i = n - 1; i > 0; i--) {

                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                Heapify_arr(arr, 0, i);

            }

        }

        public static void Heapify_arr(int arr[], int i, int n) {

            for (int x = 0; x < arr.length; x++) {
                System.out.print(arr[x] + " - ");

            }
            System.out.println("");

            int left = (i * 2) + 1;
            int right = (i * 2) + 2;

            int mid = i;

            if (left < n && arr[left] > arr[mid]) {
                mid = left;

            }
            if (right < n && arr[right] > arr[mid]) {
                mid = right;

            }

            if (mid != i) {

                int temp = arr[i];
                arr[i] = arr[mid];
                arr[mid] = temp;

                Heapify_arr(arr, mid, n);

            }

        }
    }

    public static void main(String[] args) {

        PriorityQueue<student> pq = new PriorityQueue<>();

        pq.add(new student("subi", 12));
        pq.add(new student("dubi", 10));
        pq.add(new student("mubi", 1));
        pq.add(new student("cubi", 5));

        // while (!pq.isEmpty()) {
        // System.out.println(pq.remove().name);

        // }

        // Heap h = new Heap();

        // h.add(3);
        // h.add(4);
        // h.add(1);
        // h.add(5);

        // while (!h.isEMP()) {

        // System.out.println(h.delete());
        // }

        int arr[] = { 1, 2, 4, 5, 3 };

        Heap.heap_sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }

    }

}
