import java.util.ArrayList;

public class BST {

    public static class node {

        int data;
        node left;
        node right;

        node(int val) {
            data = val;
            left = null;
            right = null;
        }

    }

    public static boolean search(node root, int key) {

        if (root == null) {
            return false;
        }

        if (root.data == key) {

            return true;

        } else if (root.data < key) {

            return search(root.right, key);

        } else {

            return search(root.left, key);
        }
    }

    static int idx = -1;

    public static node insert(node root, int value) {

        if (root == null) {
            return new node(value);
        }
        if (root.data > value) {
            root.left = insert(root.left, value);

        } else {
            root.right = insert(root.right, value);
        }

        return root;

    }

    public static void inorder(node root) {

        if (root == null) {
            return;

        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);

    }

    public static node delete(node root, int val) {

        if (root.data > val) {
            root.left = delete(root.left, val);

        }
        if (root.data < val) {
            root.right = delete(root.right, val);

        }
        if (root.data == val) {

            if (root.left == null && root.right == null) {
                return null;

            }
            if (root.left == null) {
                return root.right;

            }
            if (root.right == null) {
                return root.left;

            }

            node IS = inorder_successor(root.right);

            root.data = IS.data;

            root.right = delete(root.right, IS.data);

        }

        return root;

    }

    public static node inorder_successor(node root) {

        while (root.left != null) {
            root = root.left;

        }

        return root;
    }

    public static void print_in_range(node root, int st, int end) {

        if (root == null) {
            return;
        }

        if (root.data >= st && root.data <= end) {

            print_in_range(root.left, st, end);
            System.out.println(root.data);
            print_in_range(root.right, st, end);

        } else if (root.data < st) {

            print_in_range(root.left, st, end);

        } else {
            print_in_range(root.right, st, end);

        }
    }

    public static void print_path(ArrayList<Integer> list) {

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " -> ");

        }
        System.out.println("NULL");

    }

    public static void path(node root, ArrayList<Integer> list) {
        if (root == null) {
            return;

        }

        list.add(root.data);

        if (root.left == null && root.right == null) {

            print_path(list);

        }

        path(root.left, list);
        path(root.right, list);
        list.remove(list.size() - 1);

    }

    public static boolean valid_BST(node root, node min, node max) {

        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min.data) {
            return false;
        } else if (max != null && root.data >= max.data) {
            return false;
        }

        return valid_BST(root.left, min, root) && valid_BST(root.right, root, max);

    }

    public static node array_to_BST(int arr[], int st, int end) {

        System.out.println("st = " + st + " end = " + end);

        if (st > end) {
            System.out.println("RETERNED ");

            return null;

        }

        int mid_idx = (st + end) / 2;

        node root = new node(arr[mid_idx]);
        System.out.println(arr[mid_idx] + "node created");

        root.left = array_to_BST(arr, st, mid_idx - 1);
        root.right = array_to_BST(arr, mid_idx + 1, end);

        return root;

    }

    static class info {

        boolean is_BST;
        int size;
        int max;
        int min;

        public info(boolean is_BST, int size, int max, int min) {

            this.is_BST = is_BST;
            this.size = size;
            this.max = max;
            this.min = min;

        }

    }

    public static int BST_size = 0;

    public static info lar_BST(node root) {

        if (root == null) {
            return new info(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        info left = lar_BST(root.left);
        info right = lar_BST(root.right);

        int size = left.size + right.size + 1;
        int max = Math.max(root.data, Math.max(left.max, right.max));
        int min = Math.min(root.data, Math.min(left.min, right.min));

        if (root.data <= left.max || root.data >= right.min) {

            return new info(false, size, max, min);

        }

        if (left.is_BST && right.is_BST) {

            BST_size = Math.max(BST_size, size);

            return new info(true, size, max, min);

        }

        return new info(false, size, max, min);

    }

    public static void get_inorder(node root, ArrayList<Integer> arr) {

        if (root == null) {
            return;
        }

        get_inorder(root.left, arr);
        arr.add(root.data);
        get_inorder(root.right, arr);

    }

    public static void merge_BST(node root_1, node root_2) {

        ArrayList<Integer> arr_1 = new ArrayList<>();
        get_inorder(root_1, arr_1);

        for (int i = 0; i < arr_1.size(); i++) {
            System.out.println(arr_1.get(i));

        }

        ArrayList<Integer> arr_2 = new ArrayList<>();
        get_inorder(root_2, arr_2);

        for (int i = 0; i < arr_1.size(); i++) {
            System.out.println(arr_2.get(i));

        }
        ArrayList<Integer> m_arr = new ArrayList<>();

        int i = 0;
        int j = 0;

        int arr_1_size = arr_1.size();
        int arr_2_size = arr_2.size();

        while (i < arr_1_size && j < arr_2_size) {

            Integer a_1 = arr_1.get(i);
            Integer a_2 = arr_2.get(j);

            if (a_1 > a_2) {

                m_arr.add(a_2);
                j++;

            } else {
                m_arr.add(a_1);
                i++;

            }

        }

        while (i < arr_1_size) {
            Integer a_1 = arr_1.get(i);
            m_arr.add(a_1);

            i++;

        }
        while (j < arr_2_size) {
            Integer a_2 = arr_2.get(j);
            m_arr.add(a_2);

            j++;

        }

        for (int x = 0; x < m_arr.size(); x++) {
            System.out.println(m_arr.get(x));

        }

    }

    public static void main(String[] args) {

        // node root = new node(4);
        // root.left = new node(2);
        // root.left.left = new node(1);
        // root.left.right = new node(3);
        // root.right = new node(5);
        // root.right.right = new node(6);

        // search(root, 6);

        // int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };

        // node root = null;

        // for (int i = 0; i < values.length; i++) {
        // root = insert(root, values[i]);
        // }

        // inorder(root);
        // System.out.println(" ");

        // print_in_range(root,3, 12);
        // path(root, new ArrayList<>());

        // System.out.println(valid_BST(root, null, null));

        // int arr[] = { 3, 5, 6, 8, 10, 11, 12 };

        // node root = array_to_BST(arr, 0, arr.length - 1);

        // inorder(root);

        // info ans = lar_BST(root);

        // System.out.println(BST_size);

        node root_1 = new node(2);
        root_1.left = new node(1);
        root_1.right = new node(4);

        node root_2 = new node(9);
        root_2.left = new node(3);
        root_2.right = new node(12);

        merge_BST(root_1, root_2);

    }

}
