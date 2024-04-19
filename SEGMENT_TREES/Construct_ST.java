public class Construct_ST {

    static int tree[];

    public static void init(int n) {
        tree = new int[4 * n];

    }

    public static int buildST(int arr[], int i, int st, int ed) {

        if (st == ed) {

            tree[i] = arr[st];

            return arr[st];
        }

        int mid = (st + ed) / 2;

        buildST(arr, 2 * i + 1, st, mid);
        buildST(arr, 2 * i + 2, mid + 1, ed);

        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];

        return tree[i];
    }

    public static int get_sum(int arr[], int st, int ed) {

        return get_sum_helper(0, st, ed, 0, arr.length - 1);

    }

    public static int get_sum_helper(int i, int qi, int qj, int si, int sj) {

        if (qj <= si || qi >= sj) {
            return 0;

        } else if (si >= qi && sj <= qj) {
            return tree[i];
        } else {

            int mid = (si + sj) / 2;

            int left = get_sum_helper(2 * i + 1, qi, qj, si, mid);
            int right = get_sum_helper(2 * i + 2, qi, qj, mid + 1, sj);

            return left + right;
        }

    }

    public static void update_helper(int i, int si, int sj, int idx, int diff) {

        if (idx > sj || idx < si) {
            return;

        }

        tree[i] += diff;

        if (si != sj) {

            int mid = (si + sj) / 2;
            update_helper(2 * i + 1, si, mid, idx, diff);
            update_helper(2 * i + 2, mid + 1, sj, idx, diff);

        }

    }

    public static void update(int arr[], int idx, int new_val) {

        int n = arr.length;
        int diff = new_val - arr[idx];

        arr[idx] = new_val;

        update_helper(0, 0, n - 1, idx, diff);

    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };

        int n = arr.length;

        init(n);

        buildST(arr, 0, 0, n - 1);

        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");

        }
        System.out.println();

        System.out.println(get_sum(arr, 2, 5));

        update(arr, 2, 2);
        System.out.println(get_sum(arr, 2, 5));

    }
}
