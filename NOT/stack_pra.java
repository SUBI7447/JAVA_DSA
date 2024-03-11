import java.util.Stack;

public class stack_pra {

    public static void print(Stack<Integer> st) {

        Stack<Integer> temp = new Stack<>();
        temp.addAll(st);

        while (!temp.empty()) {

            System.out.print(temp.peek() + " - ");
            temp.pop();

        }
        System.out.println();

    }

    public static void Rev_Stack(Stack<Integer> st) {

        if (st.empty()) {
            return;
        }

        int val = st.pop();
        Rev_Stack(st);
        push_at_end(st, val);

        // print(st);

    }

    public static void Rev_String(String str) {

        String ans = "";

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            st.push(str.charAt(i));

        }

        for (int i = 0; i < str.length(); i++) {

            ans += st.pop();

        }

        System.out.println(ans);
    }

    public static void push_at_end(Stack<Integer> st, int val) {

        if (st.isEmpty()) {

            st.push(val);
            return;

        }

        int temp = st.pop();
        push_at_end(st, val);
        st.push(temp);

    }

    public static void stock_span(int stock[], int span[]) {

        Stack<Integer> index = new Stack<>();

        span[0] = 1;
        index.push(0);

        for (int i = 1; i < stock.length; i++) {

            while (stock[i] > stock[index.peek()] && !index.isEmpty()) {

                index.pop();

            }
            if (index.isEmpty()) {

                span[i] = i + 1;

            } else {
                span[i] = i - index.peek();
            }

            index.push(i);

        }

    }

    public static void next_grt(int arr[]) {

        Stack<Integer> st = new Stack<>();

        int ans[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }

            st.push(arr[i]);

        }

        for (int i = 0; i < ans.length; i++) {

            System.out.print(ans[i] + " ");

        }
        System.out.println();

        for (int i = 0; i < ans.length; i++) {

            System.out.print(arr[i] + " ");

        }

    }

    public static boolean parentheses(String str) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                st.push(str.charAt(i));
            } else {

                if (st.isEmpty()) {
                    return false;
                }
                if (str.charAt(i) == '}' && st.peek() == '{') {
                    st.pop();
                } else if (str.charAt(i) == ']' && st.peek() == '[') {
                    st.pop();
                } else if (str.charAt(i) == ')' && st.peek() == '(') {
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        return st.empty() ? true : false;

    }

    public static boolean double_paran(String str) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == ')') {

                int count = 0;

                while (st.peek() != '(') {
                    st.pop();
                    count++;
                }
                if (count < 1) {
                    return true;
                } else {
                    st.pop();
                }
            } else {
                st.push(str.charAt(i));
            }
        }

        return false;
    }

    public static int maxArea(int arr[]) {

        Stack<Integer> sl = new Stack<>();
        Stack<Integer> sr = new Stack<>();
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            while (!sl.empty() && arr[i] <= arr[sl.peek()]) {
                sl.pop();
            }
            if (sl.empty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = sl.peek();
            }

            sl.push(i);

        }
        for (int i = arr.length - 1; i >= 0; i--) {

            while (!sr.empty() && arr[i] <= arr[sr.peek()]) {
                sr.pop();
            }
            if (sr.empty()) {
                nsr[i] = -1;
            } else {
                nsr[i] = sr.peek();
            }

            sr.push(i);

        }

        int max_area = 0;

        for (int i = 0; i < arr.length; i++) {

            max_area = Integer.max(max_area, arr[i] * (nsr[i] - nsl[i] - 1));

        }

        return max_area;

    }

    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();


        // st.push(1);
        // st.push(2);
        // st.push(3);

        // print(st);

        // push_at_end(st, 4);
        // print(st);

        // push_at_end(st, 5);
        // print(st);

        // String str = "abcde";

        // Rev_String(str);

        // Rev_Stack(st);

        // print(st);

        // int stock[] = { 100, 80, 60, 70, 60, 85, 100 };
        // int span[] = new int[stock.length];

        // stock_span(stock, span);

        // for (int i = 0; i < span.length; i++) {
        // System.out.print(span[i] + " ");

        // }

        int arr[] = { 2, 1, 5, 6, 2, 3 };

        // next_grt(arr);

        // String str1 = "((a+b))";
        // String str2 = "(a-b)";

        // System.out.println(double_paran(str1));

        // System.out.println(parentheses(str));

        System.out.println(maxArea(arr));

    }

}
