import java.util.ArrayList;

public class queue_list {

    static class node {

        int data;
        node next;

        node(int val) {
            data = val;
            next = null;
        }

    }

    static class que {

        static node head = null;
        static node tail = head;

        public static void add(int val) {

            if (head == null) {
                head = tail = new node(val);
            } else {

                node new_n = new node(val);
                tail.next = new_n;
                tail = new_n;
            }

        }

        public static int remove() {

            if (is_emp()) {

                return -1;

            }

            int val = head.data;
            head = head.next;

            return val;

        }

        public static boolean is_emp() {

            if (head == null) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {

        que Q = new que();
        Q.add(1);
        Q.add(4);
        Q.add(3);

        while (Q.is_emp() == false) {

            System.out.print(Q.remove());

        }

    }

}
