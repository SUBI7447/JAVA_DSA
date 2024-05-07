import org.w3c.dom.Node;

public class linked_list_pra {

    public static class node {

        int data;
        node next;

        public node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static void print(node head) {

        if (head == null) {
            System.out.println("EMPTY LL");
        } else {
            while (head != null) {
                System.out.print(head.data + " -> ");
                head = head.next;
            }

            System.out.println(" NULL ");

        }

    }

    public static int merged_node(node head_1, node head_2) {

        node temp1 = head_1;
        node temp2 = head_2;

        int head_1_size = 0;
        int head_2_size = 0;

        int node = 0;

        while (head_1 != null || head_2 != null) {

            if (head_1 != null) {
                head_1 = head_1.next;
                head_1_size++;
                System.out.println("h1 ++");

            }
            if (head_2 != null) {
                head_2 = head_2.next;
                head_2_size++;
                System.out.println("h2 ++");
            }
        }
        if (head_1_size > head_2_size) {
            int diff = head_1_size - head_2_size;
            while (diff > 0) {
                temp1 = temp1.next;
                diff--;
            }
        } else {
            int diff = head_2_size - head_1_size;
            while (diff > 0) {
                temp2 = temp2.next;
                diff--;
            }
        }
        while (temp1.data != temp2.data) {
            System.out.println(temp1.data + " " + temp2.data);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return temp1.data;

    }

    public static void DELETE_M_N(int m, int n, node head) {

        node temp = head;
        m--;
        n++;

        while (m > 0 && temp != null) {
            temp = temp.next;
            m--;
        }

        node end = temp;

        while (n > 0 && temp != null) {
            temp = temp.next;
            n--;
        }

        end.next = temp;

        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }

    }

    public static void Swap_nodes(int i, int j, node head) {

        node temp = head;
        node left = null;
        node right = null;
        node l_prev = null;
        node r_prev = null;

        int m = 1;

        while (temp != null) {

            if (left == null) {
                l_prev = temp;
            }
            if (right == null) {
                r_prev = temp;
            }

            if (m == i - 1) {
                left = temp.next;
            }
            if (m == j - 1) {
                right = temp.next;
            }

            temp = temp.next;
            m++;
        }

        System.out.println(left.data);
        System.out.println(right.data);
        System.out.println(l_prev.data);
        System.out.println(r_prev.data);

        node l_next = left.next;

        l_prev.next = right;
        r_prev.next = left;
        left.next = right.next;
        right.next = l_next;

        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;

        }

    }

    public static void EVEN_ODD(node head) {

        node end = head;
        node prev = null;
        node curr = head;
        while (end.next != null)
            end = end.next;
        node new_end = end;
        while (curr.data % 2 != 0 && curr != end) {
            new_end.next = curr;
            curr = curr.next;
            new_end.next.next = null;
            new_end = new_end.next;
        }
        if (curr.data % 2 == 0) {
            head = curr;
            while (curr != end) {
                if (curr.data % 2 == 0) {
                    prev = curr;
                    curr = curr.next;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                    new_end.next = curr;
                    new_end = curr;
                    curr = prev.next;
                }
            }
        } else
            prev = curr;
        if (new_end != end && end.data % 2 != 0) {
            prev.next = end.next;
            end.next = null;
            new_end.next = end;
        }

        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;

        }

    }

    public static void merge(node head_1, node head_2, node head_3, int n) {

        node ans = null;


        if (head_1.data < head_2.data && (head_2.data < head_3.data)) {

            System.out.println(head_1.data + "IS SET IN HEAD");

            ans = head_1;
            head_1 = head_1.next;

        } else if (head_2.data < head_1.data && (head_1.data < head_3.data)) {
            System.out.println(head_2.data + "IS SET IN HEAD");

            ans = head_2;
            head_2 = head_2.next;

        } else {
            System.out.println(head_3.data + "IS SET IN HEAD");
            ans = head_3;
            head_3 = head_3.next;
        }
        
        node temp = ans;
        int x = (n * 3) - 1;

        while ((head_1 != null || head_2 != null || head_3 != null) && (x > 0)) {

            System.out.println(head_1.data + " " + head_2.data + " " + head_3.data);

            if (head_1.data < head_2.data && (head_1.data < head_3.data) && head_1 != null) {

                System.out.println(head_1.data + "IS SET ");

                ans.next = head_1;
                head_1 = head_1.next;

            } else if (head_2.data < head_1.data && (head_2.data < head_3.data) && head_2 != null) {

                System.out.println(head_2.data + "IS SET ");

                ans.next = head_2;
                head_2 = head_2.next;

            } else if (head_3 != null) {

                System.out.println(head_3.data + "IS SET ");
                ans.next = head_3;
                head_3 = head_3.next;
            }
            ans = ans.next;

            if (head_1 == null) {
                head_1 = new node(Integer.MAX_VALUE);
            }
            if (head_2 == null) {
                head_2 = new node(Integer.MAX_VALUE);
            }
            if (head_3 == null) {
                head_3 = new node(Integer.MAX_VALUE);
            }
            x--;
            System.out.println("\n");

        }

        while (temp != null) {

            System.out.print(temp.data + " -> ");
            temp = temp.next;

        }

    }

    public static void main(String[] args) {

        linked_list_pra ll_1 = new linked_list_pra();
        linked_list_pra ll_2 = new linked_list_pra();

        node node_1 = new node(1);
        node node_2 = new node(2);
        node node_3 = new node(3);
        node node_4 = new node(44);

        node second_node_1 = new node(10);
        node second_node_2 = new node(20);
        node second_node_3 = new node(30);
        node second_node_4 = new node(40);

        node third_node_1 = new node(15);
        node third_node_2 = new node(25);
        node third_node_3 = new node(35);
        node third_node_4 = new node(105);

        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;
        node_4.next = null;

        second_node_1.next = second_node_2;
        second_node_2.next = second_node_3;
        second_node_3.next = second_node_4;
        second_node_4.next = null;

        third_node_1.next = third_node_2;
        third_node_2.next = third_node_3;
        third_node_3.next = third_node_4;
        third_node_4.next = null;

        merge(node_1, second_node_1, third_node_1, 4);

    }

}
