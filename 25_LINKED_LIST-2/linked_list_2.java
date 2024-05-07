public class linked_list_2 {

    public static class node {

        int data;
        node next;

        public node(int val) {
            data = val;
            next = null;
        }
    }

    public static node head;
    public static node tail;
    static int size = 0;

    public void add(int val) {

        node temp = new node(val);

        if (head == null) {
            head = tail = temp;

        } else {

            temp.next = head;
            head = temp;

        }

    }

    public void print() {

        node temp = head;
        int n = 15;
        while (temp != null && n != 0) {

            System.out.print(temp.data + " -> ");
            temp = temp.next;
            n--;

        }
        System.out.println(" NULL ");
    }

    public void is_cycle() {

        node slow = head.next;
        node fast = head.next.next;

        while (fast.next != null && fast != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                System.out.println("IS CYCLE");
                return;

            }

        }
        System.out.println("IS NOT CYCLE");
    }

    public void remove_cycle() {

        node slow = head.next;
        node fast = head.next.next;
        node prev = null;

        while (slow != fast) {

            slow = slow.next;
            fast = fast.next.next;

        }
        prev = fast;
        slow = head.next;
        fast = fast.next;
        while (slow != fast) {

            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
    }

    public node mid(node head) {
        node slow = head;
        node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public node merge(node left, node right) {

        node merge = new node(-1);
        node temp = merge;

        while (left != null && right != null) {

            if (left.data <= right.data) {

                temp.next = left;
                left = left.next;
                temp = temp.next;

            } else {

                temp.next = right;
                right = right.next;
                temp = temp.next;
            }

        }

        while (left != null) {

            temp.next = left;
            left = left.next;
            temp = temp.next;
        }

        while (right != null) {

            temp.next = right;
            right = right.next;
            temp = temp.next;
        }

        return merge.next;

    }

    public node merger_sort(node head) {

        if (head == null || head.next == null) {
            return head;

        }

        node mid = mid(head);

        node right = mid.next;

        mid.next = null;

        node left_n = merger_sort(head);
        node right_n = merger_sort(right);

        return merge(left_n, right_n);

    }

    public void zig_zag() {

        node slow = head;
        node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        node mid = slow;

        node curr = mid.next;
        mid.next = null;
        node prev = null;
        node next;

        while (curr != null) {

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }

        node left = head;
        node right = prev;

        node nextL, nextR;

        while (left != null && right != null) {

            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;

        }

    }

    public static void main(String[] args) {

        linked_list_2 ll = new linked_list_2();

        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);

        ll.print();
        // ll.is_cycle();

        // head.next.next.next.next.next = head.next.next;
        // ll.print();
        // ll.is_cycle();

        // ll.remove_cycle();

        // ll.print();
        // ll.is_cycle();

        // ll.head = ll.merger_sort(head);

        // ll.print();
        ll.zig_zag();
        ll.print();


    }

}
