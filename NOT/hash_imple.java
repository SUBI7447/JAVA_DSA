import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

import org.w3c.dom.Node;


public class hash_imple {

    static class HashMap<K, V> {

        private class node {

            K key;
            V value;

            public node(K key, V value) {
                this.key = key;
                this.value = value;
            }

        }

        private int n;

        private int N;
        private LinkedList<node> bucket[];

        @SuppressWarnings("unchecked")

        public HashMap() {
            this.N = 4;
            this.bucket = new LinkedList[4];

            for (int i = 0; i < 4; i++) {
                this.bucket[i] = new LinkedList<>();
            }
        }

        private int hashFun(K key) {

            int hc = key.hashCode();
            return Math.abs(hc) % N;

        }

        private int SearchInLL(K key, int bi) {
            LinkedList<node> ll = bucket[bi];
            int di = 0;

            for (int i = 0; i < ll.size(); i++) {
                node nod = ll.get(i);

                if (nod.key == key) {

                    return di;
                }
                di++;

            }
            return -1;

        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<node> oldBuck[] = bucket;

            bucket = new LinkedList[N * 2];
            N = N * 2;

            for (int i = 0; i < bucket.length; i++) {
                bucket[i] = new LinkedList<>();

            }

            for (int i = 0; i < oldBuck.length; i++) {

                LinkedList<node> ll = oldBuck[i];

                for (int j = 0; j < ll.size(); j++) {
                    node NODE = ll.remove();
                    put(NODE.key, NODE.value);

                }

            }
        }

        public void put(K key, V value) {

            int bi = hashFun(key);
            int di = SearchInLL(key, bi);

            if (di != -1) {

                node Node = bucket[bi].get(di);
                Node.value = value;
            } else {
                bucket[bi].add(new node(key, value));
                n++;
            }

            double lambda = (double) n / N;

            if (lambda > 2.0) {

                rehash();
            }

        }

        public boolean contains(K key) {
            int bi = hashFun(key);
            int di = SearchInLL(key, bi);

            if (di != -1) {

                return true;
            } else {
                return false;
            }
        }

        public V get(K key) {
            int bi = hashFun(key);
            int di = SearchInLL(key, bi);

            if (di != -1) {

                node Node = bucket[bi].get(di);
                return Node.value;
            } else {
                return null;
            }
        }

        public V remove(K key) {
            int bi = hashFun(key);
            int di = SearchInLL(key, bi);

            if (di != -1) {

                node Node = bucket[bi].remove(di);
                n--;
                return Node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keysets() {

            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < bucket.length; i++) {

                LinkedList<node> ll = bucket[i];

                for (node NODE : ll) {
                    keys.add(NODE.key);
                }

            }
            return keys;
        }

        public boolean isEMPTY() {

            return n == 0;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("IND", 100);
        hm.put("PAK", 1000);
        hm.put("US", 10);

        ArrayList<String> keys = hm.keysets();

        for (String k : keys) {

            System.out.println(k + " = " + hm.get(k));
        }
    }

}
