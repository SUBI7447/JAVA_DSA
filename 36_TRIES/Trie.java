public class Trie {

    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        Node() {

            for (int i = 0; i < 26; i++) {
                children[i] = null;

            }
        }

    }

    public static Node root = new Node();

    public static void insert(String word) {

        Node curr = root;// take root

        // traverse the string
        for (int level = 0; level < word.length(); level++) {// T_COMPLEX = O(L)

            // find the index
            int idx = word.charAt(level) - 'a';

            // check idx is empty or not
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();

            }

            // go to child node
            curr = curr.children[idx];

        }

        // end of word is true
        curr.eow = true;
    }

    public static boolean search(String word) {

        Node curr = root;

        for (int i = 0; i < word.length(); i++) {// T_COMPLEX = O(L)
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return false;

            }
            curr = curr.children[idx];

        }

        return curr.eow == true;

    }

    public static void print_trie(Node root) {

        for (int i = 0; i < root.children.length; i++) {

            if (root.children[i] != null) {

                char ch = (char) (i + 'a');
                System.out.print(ch);

                print_trie(root.children[i]);

            }

        }
        System.out.println();
    }

    public static void Longest_Word_in_Dict(Node root) {
        String ans = "";

        for (int i = 0; i < root.children.length; i++) {

            String curr_ans = get_str(root.children[i], "", i);

            if (ans.length() < curr_ans.length()) {
                ans = curr_ans;

            }

        }

    }

    public static String get_str(Node root, String str, int idx) {

        if (root.eow == true) {

            char ch = (char) (idx + 'a');

            str += ch;

            for (int i = 0; i < root.children.length; i++) {

                if (root.children[i] != null) {

                    str += get_str(root.children[i], str, i);

                }

            }

        } else {
            return "";
        }
        System.out.println(str);
        return str;
    }

    public static void main(String[] args) {

        String words[] = { "a","banana","app","appl","ap","apply","apple" };

        for (String str : words) {

            insert(str);

        }

        Longest_Word_in_Dict(root);

    }

}