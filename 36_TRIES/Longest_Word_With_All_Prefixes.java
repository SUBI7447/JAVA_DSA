public class Longest_Word_With_All_Prefixes {

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

    public static String ans = "";

    public static void LongestWord(Node root, StringBuilder temp) {

        if (root == null) {
            return;
        }

        for (int i = 0; i < 26; i++) {

            if (root.children[i] != null && root.children[i].eow != false) {
                char ch = (char) (i + 'a');
                temp.append(ch);

                if (temp.length() > ans.length()) {
                    ans = temp.toString();

                }
                LongestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }

        }

    }

    public static void main(String[] args) {

        String words[] = { "a", "banana", "app", "appl", "ap", "apply", "apple" };

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);

        }

        LongestWord(root, new StringBuilder(""));
        System.out.println(ans);

    }

}
