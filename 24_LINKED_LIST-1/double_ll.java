public class double_ll {

    public class node {

        int data;
        node next;
        node prev;

        public node(int data) {

            this.data = data;
            prev = null;
            next = null;

        }

    }

    public static node head;
    public static node tail;
    public static int size;

    public void add_first(int data) {

        size++;
        node new_node = new node(data);
        if (head == null) {
            head = tail = new_node;
        } else {
            head.prev = new_node;
            new_node.next = head;
            head = new_node;
        }
    }

    public void add_last(int data) {

        size++;
        node new_node = new node(data);
        if (tail == null) {
            head = tail = new_node;
        } else {
            tail.next = new_node;
            new_node.prev = tail;
            tail = new_node;
        }
    }

    public void remove_first() {

        if (head.next == null) {
            head = tail = null;
        }

        head = head.next;
        head.prev = null;
        size--;
    }

    public void remove_last() {

        if (head.next == null) {
            head = tail = null;
        }

        tail = tail.prev;
        tail.next = null;
        size--;
    }

    public void reverse() {

        node curr = head;
        node prev = null;
        node next;
        tail = head;

        while (curr != null) {

            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;

        }
        head = prev;

        System.out.println("REVERSED");

    }

    public void print() {

        node temp_H = head;
        node temp_T = tail;

        if (head == null) {
            System.out.println("DLL is empty");
        } else {

            while (temp_H != null) {
                System.out.print(temp_H.data + " -> ");
                temp_H = temp_H.next;
            }
            System.out.println(" NULL ");
            while (temp_T != null) {
                System.out.print(temp_T.data + " -> ");
                temp_T = temp_T.prev;
            }
            System.out.println(" NULL \n");
        }

    }

    public static void main(String[] args) {

        double_ll dll = new double_ll();

        dll.print();
        dll.add_first(10);
        dll.print();
        dll.add_last(20);

        dll.print();
        dll.add_first(30);
        dll.print();
        dll.add_last(40);

        dll.print();
        dll.add_first(50);
        dll.print();
        dll.add_last(60);
        dll.print();
        dll.remove_first();
        dll.print();
        dll.remove_last();
        dll.print();

        dll.reverse();
        dll.print();
        dll.reverse();
        dll.print();
        System.out.println("SIZE : " + size);
    }

}
