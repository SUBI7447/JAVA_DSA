import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class hash {

    public static void main(String[] args) {

        // HashMap<String, Integer> hm = new HashMap<>();

        // hm.put("IND", 100);
        // hm.put("BHU", 10);
        // hm.put("CHI", 500);
        // hm.put("PAK", 60);

        // Set<String> keys = hm.keySet();

        // for (String k : keys) {

        // System.out.println(k + " = " + hm.get(k));
        // }

        // LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        // lhm.put("A", 100);
        // lhm.put("B", 10);
        // lhm.put("C", 500);
        // lhm.put("D", 60);

        // System.out.println(lhm);

        TreeMap<String, Integer> tm = new TreeMap<>();

        // tm.put("A", 100);
        // tm.put("Z", 10);
        // tm.put("C", 500);
        // tm.put("D", 60);

        // System.out.println(tm);
        // HashSet<String> hs = new HashSet<>();
        // hs.add("A");
        // hs.add("B");
        // hs.add("C");
        // hs.add("D");

        // Iterator it = hs.iterator();

        // while (it.hasNext()) {
        // System.out.println(it.next());

        // }

        // for (String KEY : hs) {
        // System.out.println(KEY);

        // }

        // LinkedHashSet<String> hs = new LinkedHashSet<>();
        // hs.add("A");
        // hs.add("B");
        // hs.add("C");
        // hs.add("D");

        // Iterator it = hs.iterator();

        // while (it.hasNext()) {
        // System.out.println(it.next());

        // }

        // for (String KEY : hs) {
        // System.out.println(KEY);

        // }

        TreeSet<String> hs = new TreeSet<>();
        // hs.add("Z");
        // hs.add("B");
        // hs.add("C");
        // hs.add("D");

        // Iterator it = hs.iterator();

        // while (it.hasNext()) {
        // System.out.println(it.next());

        // }

        // for (String KEY : hs) {
        // System.out.println(KEY);

        // }

        // int nums[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };

        // majority(nums);

        // System.out.println(anagram("tulip", "lipid"));

        // int nums[] = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1 };

        // distinct(nums);

        // int a1[] = { 7, 3, 9 };
        // int a2[] = { 6, 3, 9, 2, 9, 4 };

        // union(a1, a2);
        // intersection(a1, a2);

        // HashMap<String, String> hmap = new HashMap<>();

        // hmap.put("CHEE", "BENG");
        // hmap.put("MUMB", "DEL");
        // hmap.put("GOA", "CHEE");
        // hmap.put("DEL", "GOA");

        // itinerary(hmap);

        int arr[] = { 10, 2, -2, -20, 10 };

        // l_suba_sum(arr);
        t_sub_arr_s(arr,-10);

    }

    public static void t_sub_arr_s(int arr[],int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0, 1);
        int sum = 0;
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if (hmap.containsKey(sum-k)) {
                ans+=hmap.get(sum-k);
                
            }
            hmap.put(sum,hmap.getOrDefault(sum,0)+1);
            
        }
        System.out.println(ans);

    }

    public static void l_suba_sum(int arr[]) {

        HashMap<Integer, Integer> hmap = new HashMap<>();
        int sum = 0;
        int len = 0;

        for (int j = 0; j < arr.length; j++) {
            sum = sum + arr[j];

            if (hmap.containsKey(sum)) {
                len = Math.max(len, j - hmap.get(sum));

            } else {
                hmap.put(sum, j);
            }

        }
        System.out.println(len);

    }

    public static void itinerary(HashMap<String, String> hmap) {

        for (String key : hmap.keySet()) {

            if (!hmap.containsValue(key)) {

                System.out.print(key + " -> ");

                String K = key;

                while (hmap.containsKey(K)) {
                    System.out.print(hmap.get(K) + " -> ");
                    K = hmap.get(K);
                }
                return;

            }

        }

    }

    public static void union(int a1[], int a2[]) {

        HashSet<Integer> hset = new HashSet<>();

        for (int i = 0; i < a1.length; i++) {
            hset.add(a1[i]);
        }
        for (int i = 0; i < a2.length; i++) {
            hset.add(a2[i]);
        }

        System.out.println(hset);
    }

    public static void intersection(int a1[], int a2[]) {

        HashSet<Integer> hset = new HashSet<>();

        for (int i = 0; i < a2.length; i++) {
            hset.add(a2[i]);
        }
        for (int i = 0; i < a1.length; i++) {

            if (hset.contains(a1[i])) {
                hset.remove(a1[i]);

                System.out.print(a1[i] + " ");
            }
        }

    }

    public static void distinct(int nums[]) {

        HashSet<Integer> hset = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            hset.add(nums[i]);

        }

        System.out.println(hset.size());
    }

    public static boolean anagram(String a, String b) {

        HashMap<Character, Integer> hmap = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {

            hmap.put(a.charAt(i), hmap.getOrDefault(a.charAt(i), 0) + 1);

        }
        System.out.println(hmap);

        for (int i = 0; i < b.length(); i++) {

            if (hmap.containsKey(b.charAt(i))) {

                System.out.println(b.charAt(i) + " is in map ");

                hmap.put(b.charAt(i), hmap.get(b.charAt(i)) - 1);

                if (hmap.get(b.charAt(i)) == 0) {

                    System.out.println(b.charAt(i) + " deleted ");
                    hmap.remove(b.charAt(i));

                }
            } else {

                System.out.println(b.charAt(i) + " is not in map ");
                return false;
            }
        }

        if (hmap.isEmpty()) {

            return true;
        } else {
            return false;
        }

    }

    public static void majority(int nums[]) {

        HashMap<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);

        }

        System.out.println(hmap);

        for (Integer K : hmap.keySet()) {

            if (hmap.get(K) > (nums.length / 3)) {

                System.out.println(K + " accept");
            } else {
                System.out.println(K + " not accept");

            }

        }

    }

}