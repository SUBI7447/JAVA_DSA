import java.util.*;

public class linkedlist {

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

    public void add_first(int val) {

        node new_node = new node(val);
        size++;

        if (head == null) {
            head = tail = new_node;
            return;
        }
        new_node.next = head;
        head = new_node;
    }

    public void add_last(int val) {

        node new_node = new node(val);
        size++;

        if (head == null) {
            head = tail = new_node;
            return;
        }
        tail.next = new_node;
        tail = new_node;
    }

    public void add_in_middle(int index, int val) {

        if (index == 0) {
            add_first(val);
            return;
        }

        node new_node = new node(val);
        node temp = head;
        size++;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        new_node.next = temp.next;
        temp.next = new_node;

    }

    public void remove_first() {

        if (head == null) {
            System.out.println("NO LL");

        } else if (head.next == null) {
            head = tail = null;
            size--;

        } else {

            head = head.next;
            size--;

        }

    }

    public void remove_last() {

        if (head == null) {
            System.out.println("NO LL");

        } else if (head.next == null) {
            head = tail = null;
            size--;

        } else {
            node temp = head;

            while (temp.next.next != null) {
                temp = temp.next;

            }
            temp.next = null;
            tail = temp;
            size--;
        }

    }

    public boolean search(int key) {

        node temp = head;

        while (temp.next != null) {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }
        if (temp.data == key) {
            return true;

        } else {
            return false;
        }

    }

    public boolean recersive_search(node head, int key) {

        if (head.next == null) {

            if (head.data == key) {
                return true;
            } else {
                return false;
            }

        } else if (head.data == key) {
            return true;
        } else {

            return recersive_search(head.next, key);
        }

    }

    public void reverse() {

        node prev = null;
        node curr = tail = head;
        node next;

        while (curr != null) {

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;

    }

    public node mid(node head) {
        node slow = head;
        node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean palin() {

        node mid = mid(head);
        node st = head;

        node prev = null;
        node curr = mid;
        node next;

        while (curr != null) {

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }

        node temp = prev;

        while (temp != null && st != null) {

            if (temp.data == st.data) {

                temp = temp.next;
                st = st.next;
            } else {
                return false;
            }

        }
        return true;

    }

    public void print() {

        node temp = head;
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {

        linkedlist ll = new linkedlist();
        ll.print();
        ll.add_first(2);
        ll.print();
        ll.add_first(1);
        ll.print();
        ll.add_last(3);
        ll.print();
        ll.add_last(4);
        ll.print();
        ll.add_in_middle(1, 10);
        ll.print();
        ll.add_in_middle(2, 20);
        ll.print();
        ll.add_in_middle(5, 0);
        ll.print();
        ll.remove_first();
        ll.print();
        ll.remove_first();
        ll.print();
        ll.remove_last();
        ll.print();
        System.out.println(ll.recersive_search(head, 210));
        System.out.println(ll.recersive_search(head, 20));
        System.out.println(size);
        System.out.println(ll.recersive_search(head, 0));
        System.out.println(ll.recersive_search(head, 2));
        System.out.println(ll.recersive_search(head, 3));
        ll.reverse();
        ll.print();
        System.out.println(size);

        ll.add_first(3);
        ll.add_first(2);
        ll.add_first(20);
        ll.print();

        System.out.println(ll.palin());

    }

}
