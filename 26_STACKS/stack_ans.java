import java.util.LinkedList;
import java.util.Stack;

public class stack_ans {

    public static void print(LinkedList<Character> list) {

        while (!list.isEmpty()) {
            System.out.print(list.peek() + " -> ");
            list.removeFirst();
        }
    }

    public static void IsPalindrome(LinkedList<Character> list) {

        Stack<Character> st = new Stack<>();

        int size = list.size();
        int mid = (list.size() / 2);

        System.out.println("mid : " + mid);

        while (mid > 0) {

            st.push(list.peek());
            list.removeFirst();

            mid--;

        }
        if (size % 2 != 0) {
            list.removeFirst();
        }
        while (!st.empty()) {

            System.out.println(st.peek() + " " + list.peek());
            if (st.peek() != list.peek()) {

                System.out.println("NOT PALIND");
                return;

            }
            st.pop();
            list.removeFirst();

        }

        System.out.println("PALIND");

    }

    public static String decode(String str) {

        String ans = "";

        Stack<Character> sta = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == ']') {
                String code = ans;

                while (sta.peek() != '[') {

                    code = sta.peek() + code;

                    sta.pop();

                }
                System.out.println(code + " = code");
                char pop = sta.pop();

                int times = Character.getNumericValue(sta.pop());

                System.out.println(times + " = popped");

                System.out.println("RUNNING " + times + " times");

                ans = code;
                System.out.println(ans);
                while (times > 1) {

                    ans = code + ans;
                    times--;

                }

                System.out.println(ans + " = ans");

            } else {

                sta.push(str.charAt(i));

            }
        }

        return ans;

    }

    public static void main(String[] args) {

        // LinkedList<Character> list = new LinkedList<>();
        // list.add('A');
        // list.add('B');
        // list.add('q');
        // list.add('B');
        // list.add('q');

        // // print(list);

        // IsPalindrome(list);

        String str = "q2[b3[r2[m]]]";

        String ans = decode(str);

        System.out.println(ans);

    }

}
