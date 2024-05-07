import java.util.*;

public class stack_ {

    public static class stack {

        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty() {
            return list.size() == 0;
        }

        public static void push(int data) {
            list.add(data);
        }

        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int data = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return data;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            int data = list.get(list.size() - 1);
            return data;
        }

    }

    public static class node {

        public int data;
        public node next;

        node(int val) {
            data = val;
            next = null;
        }

    }

    public static class Stack {

        public static node top = null;

        public static void push(int val) {

            if (top == null) {

                node temp = new node(val);
                top = temp;
            } else {
                node temp = new node(val);
                temp.next = top;
                top = temp;
            }

        }

        public static int pop() {

            if (top == null) {
                return -1;

            } else {

                int temp = top.data;

                top = top.next;

                return temp;
            }

        }

        public static int peek() {

            if (top == null) {
                return -1;
            }

            return top.data;
        }

        public static boolean isEmpty() {

            if (top == null) {
                return true;
            } else {
                return false;
            }

        }

    }

    public static void main(String[] args) {

        stack s = new stack();
        s.push(1);
        s.push(3);
        s.push(2);

        while (!s.isEmpty()) {

            System.out.println(s.peek());
            s.pop();

        }

        Stack S = new Stack();
        S.push(1);
        S.push(2);
        S.push(3);

        while (!S.isEmpty()) {

            System.out.println(S.peek());
            S.pop();

        }

    }

}
