import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class que {

    public static void non_rep_char(String str) {

        Queue<Character> q = new LinkedList<>();

        int freq[] = new int[26];

        for (int i = 0; i < 26; i++) {

        }

        for (int i = 0; i < str.length(); i++) {

            q.add(str.charAt(i));

            char c = str.charAt(i);

            freq[c - 'a']++;

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {

                q.remove();
            }

            if (q.isEmpty()) {

                System.out.println(-1);
            } else {

                System.out.println(q.peek());

            }

        }

    }

    public static void interleave(Queue<Integer> q1) {

        Queue<Integer> q2 = new LinkedList<>();

        int size = q1.size();
        for (int i = 0; i < size / 2; i++) {
            q2.add(q1.remove());
        }
        while (!q2.isEmpty()) {

            q1.add(q2.remove());
            q1.add(q1.remove());

        }

        while (!q1.isEmpty()) {

            System.out.println(
                    q1.remove());

        }

    }

    public static void rev(Queue<Integer> q) {

        Stack<Integer> st = new Stack<>();

        int size = q.size();

        for (int i = 0; i < size; i++) {

            st.push(q.remove());
 
        }

        while (!st.isEmpty()) {

            q.add(st.pop());

        }
        while (!q.isEmpty()) {

            System.out.println(
                    q.remove());

        }
    }

    public static void main(String[] args) {

        // String str = "aabccxb";
        // non_rep_char(str);

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        rev(q);

        // interleave(q);
    }

}
