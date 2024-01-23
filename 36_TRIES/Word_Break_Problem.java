public class Word_Break_Problem {

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

    public static boolean WordBreak(String word) {
        if (word.length() == 0) {
            return true;

        }
        for (int i = 1; i <= word.length(); i++) {

            if (search(word.substring(0, i)) && WordBreak(word.substring(i))) {
                return true;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        String words[] = { "i", "like", "sam", "samsung", "mobile", "ice" };

        for (String str : words) {

            insert(str);

        }

        System.out.println(WordBreak("ilikesamsung"));
    }

}
