// Max Element Queries
// Given an arr[ I, we have to answer few queries :
// a. Output Max for the subarray(i..j)
// {6, 8, -1, 2, 17, 1, 3, 2, 4)
// b. Update the element at idx

public class Max_ele_Queries {

    static int tree[];

    public static void init(int n) {

        tree = new int[n * 4];

    }

    public static void build_Tree(int i, int si, int sj, int arr[]) {

        if (si == sj) {
            tree[i] = arr[si];
        } else {

            int mid = (si + sj) / 2;

            build_Tree(i * 2 + 1, si, mid, arr);
            build_Tree(i * 2 + 2, mid + 1, sj, arr);

            tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
        }

    }

    public static int get_max(int arr[], int qi, int qj) {

        int n = arr.length;
        return get_max_helper(0, 0, n - 1, qi, qj);

    }

    public static int get_max_helper(int i, int si, int sj, int qi, int qj) {

        if (si > qi || sj < qi) {
            return Integer.MIN_VALUE;
        } else if (si >= qi && sj <= qj) {
            return tree[i];
        } else {
            int mid = (si + sj) / 2;

            int left = get_max_helper(2 * i + 1, si, mid, qi, qj);
            int right = get_max_helper(2 * i + 2, mid + 1, sj, qi, qj);

            return Math.max(left, right);
        }

    }

    public static void main(String[] args) {

        int arr[] = { 6, 8, -1, 2, 17, 1, 3, 2, 4 };

        int n = arr.length;
        init(n);
        build_Tree(0, 0, n - 1, arr);

        for (int i = 0; i < tree.length; i++) {

            System.out.print(tree[i] + " ");

        }
        System.out.println();
        System.out.println(get_max(arr, 2,5 ));
    }

}
