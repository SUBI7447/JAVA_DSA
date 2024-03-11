import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class binary_tree {

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

    public static class BT {

        static int idx = -1;

        public static node build_tree(int nodes[]) {
            idx++;

            if (nodes[idx] == -1) {

                return null;

            }

            node new_node = new node(nodes[idx]);

            new_node.left = build_tree(nodes);
            new_node.right = build_tree(nodes);

            return new_node;
        }

        public static void preorder(node root) {

            if (root == null) {
                // System.out.print("-1" + " ");
                return;

            }

            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);

        }

        public static void inorder(node root) {

            if (root == null) {
                // System.out.print("-1" + " ");
                return;

            }

            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);

        }

        public static void postorder(node root) {

            if (root == null) {
                // System.out.print("-1" + " ");
                return;

            }

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");

        }

        public static void level_order(node root) {

            if (root == null) {
                return;
            }

            Queue<node> que = new LinkedList<>();

            que.add(root);
            que.add(null);

            while (!que.isEmpty()) {

                node curr = que.remove();

                if (curr == null) {
                    System.out.println(" ");

                    if (que.isEmpty()) {
                        break;
                    } else {
                        que.add(null);
                    }

                } else {
                    System.out.print(curr.data + " ");
                    if (curr.left != null) {
                        que.add(curr.left);
                    }
                    if (curr.right != null) {
                        que.add(curr.right);
                    }

                }
            }

        }

        public static int height(node root) {

            if (root == null) {
                return 0;
            }

            int left_hei = height(root.left);
            int right_hei = height(root.right);

            int hei = (Integer.max(left_hei, right_hei) + 1);

            return hei;
        }

        public static int count(node root) {

            if (root == null) {
                return 0;
            }

            int left_count = count(root.left);
            int right_count = count(root.right);

            int t_count = (left_count + right_count + 1);

            return t_count;

        }

        public static int sum(node root) {

            if (root == null) {
                return 0;
            }

            int left_sum = sum(root.left);
            int right_sum = sum(root.right);

            int t_sum = (left_sum + right_sum + root.data);

            return t_sum;

        }

        static class inf {

            int dia;
            int hei;

            public inf(int dia, int hei) {

                this.dia = dia;
                this.hei = hei;
            }

        }

        public static inf diameter(node root) {

            if (root == null) {
                return new inf(0, 0);
            }

            inf l_info = diameter(root.left);
            inf r_info = diameter(root.right);

            int diam = Math.max(Math.max(l_info.dia, r_info.dia), l_info.hei + r_info.hei + 1);
            int heig = Math.max(l_info.hei, r_info.hei) + 1;
            return new inf(diam, heig);
        }

        public static boolean is_subtree(node head_root, node sub_root) {

            if (head_root == null) {
                return false;
            }

            if (head_root.data == sub_root.data) {

                if (is_iden(head_root, sub_root)) {
                    return true;

                }

            }
            if (is_subtree(head_root.left, sub_root) || is_subtree(head_root.right, sub_root)) {
                return true;

            }

            return false;
        }

        public static boolean is_iden(node head_root, node sub_root) {

            if (head_root == null && sub_root == null) {
                return true;

            } else if (head_root == null || sub_root == null || head_root.data != sub_root.data) {
                return false;
            }

            if (!is_iden(head_root.left, sub_root.left)) {
                return false;

            }

            if (!is_iden(head_root.right, sub_root.right)) {
                return false;
            }
            return true;

        }

        static class info {

            int hd;
            node Node;

            public info(int val, node node_val) {
                hd = val;
                Node = node_val;
            }

        }

        public static void top_view(node root) {

            HashMap<Integer, node> map = new HashMap<>();
            Queue<info> que = new LinkedList<>();

            int min = 0, max = 0;

            que.add(new info(0, root));
            que.add(null);

            while (!que.isEmpty()) {

                info curr = que.remove();

                if (curr == null) {

                    if (que.isEmpty()) {
                        break;
                    } else {
                        que.add(null);
                    }

                } else {

                    if (!map.containsKey(curr.hd)) {
                        map.put(curr.hd, curr.Node);
                    }

                    if (curr.Node.left != null) {
                        que.add(new info(curr.hd - 1, curr.Node.left));
                        min = Math.min(curr.hd - 1, min);
                    }
                    if (curr.Node.right != null) {
                        que.add(new info(curr.hd + 1, curr.Node.right));
                        max = Math.max(curr.hd + 1, max);
                    }
                }

            }

            for (int i = min; i <= max; i++) {

                System.out.print(map.get(i).data + " ");

            }

        }

        public static void k_th_level(node root, int level, int k) {

            if (root == null) {
                return;
            }
            if (level == k) {
                System.out.print(root.data + " ");
                return;

            }
            k_th_level(root.left, level + 1, k);

            k_th_level(root.right, level + 1, k);

        }

        public static boolean getPath(node root, int n, ArrayList<node> path) {

            if (root == null) {
                return false;

            }

            path.add(root);

            if (root.data == n) {
                return true;
            }

            boolean found_l = getPath(root.left, n, path);
            boolean found_R = getPath(root.right, n, path);

            if (found_R || found_l) {
                return true;
            }
            path.remove(path.size() - 1);
            return false;
        }

        public static node l_c_a(node root, int n1, int n2) {

            ArrayList<node> path1 = new ArrayList<>();
            ArrayList<node> path2 = new ArrayList<>();

            getPath(root, n1, path1);
            getPath(root, n2, path2);
            int i = 0;
            for (i = 0; i < path1.size() && i < path2.size(); i++) {

                if (path1.get(i) != path2.get(i)) {
                    break;
                }
            }

            node lca = path1.get(i - 1);

            return lca;

        }

        public static node lca(node root, int n1, int n2) {

            if (root == null) {
                return null;
            }
            if (root.data == n1 || root.data == n2) {
                return root;
            }

            node l_lca = lca(root.left, n1, n2);
            node r_lca = lca(root.right, n1, n2);

            if (r_lca == null) {
                return l_lca;

            }
            if (l_lca == null) {
                return r_lca;

            }
            return root;
        }

        public static int dis(node root, int n) {

            if (root == null) {
                return -1;
            }

            if (root.data == n) {
                return 0;
            }

            int dist_l = dis(root.left, n);

            int dist_r = dis(root.right, n);

            if (dist_l == -1 && dist_r == -1) {
                return -1;

            } else if (dist_l == -1) {
                return dist_r + 1;
            } else {
                return dist_l + 1;
            }
        }

        public static int min_dis(node root, int n1, int n2) {

            node LCA = lca(root, n1, n2);

            int l_dis = dis(LCA, n1);
            int r_dis = dis(LCA, n2);

            return l_dis + r_dis;
        }

        public static int k_th_ans(node root, int n, int k) {

            if (root == null) {
                return -1;
            }

            if (root.data == n) {
                return 0;
            }

            int l_dis = k_th_ans(root.left, n, k);
            int r_dis = k_th_ans(root.right, n, k);

            if (l_dis == -1 && r_dis == -1) {
                return -1;

            }

            int max = Math.max(l_dis, r_dis);

            if (max + 1 == k) {
                System.out.println(root.data);

            }
            return max + 1;

        }

        public static int sum_tree(node root) {

            if (root == null) {
                return 0;
            }

            int sum = sum_tree(root.left) + sum_tree(root.right);
            int t = sum + root.data;

            root.data = sum;

            return t;

        }

        public static void mirror(node root) {

            if (root == null) {
                return;

            }

            node temp = root.left;

            root.left = root.right;
            root.right = temp;

            mirror(root.left);
            mirror(root.right);
        }

        static ArrayList<Integer> list = new ArrayList<>();

        public static void delete(node root, int k) {

            if (root == null) {
                return;
            }
            if (root.left != null) {
                if (root.left.left == null && root.left.right == null && root.left.data == k) {
                    root.left = null;
                }
            }
            if (root.right != null) {
                if (root.right.left == null && root.right.right == null && root.right.data == k) {
                    root.right = null;
                }
            }

            delete(root.left, k);
            delete(root.right, k);

        }

    }

    public static void main(String[] args) {

        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };

        BT tree = new BT();
        node root = tree.build_tree(nodes);
        // System.out.println(root.left.data);

        // tree.preorder(root);
        // tree.inorder(root);
        // tree.postorder(root);

        // tree.level_order(root);

        // // System.out.println(tree.sum(root));
        // System.out.println(tree.diameter(root).dia);

        // node sub_root = new node(2);
        // sub_root.left = new node(4);
        // sub_root.right = new node(5);

        // System.out.println(tree.is_subtree(root, sub_root));

        // tree.k_th_level(root, 1, 2);

        // System.out.println(tree.min_dis(root, 4, 6));
        // System.out.println(tree.k_th_ans(root, 5, 2));
        // System.out.println(tree.sum_tree(root));

        // tree.level_order(root);
        // tree.mirror(root);
        tree.level_order(root);

        tree.delete(root, 1);

        tree.level_order(root);
    }

}
