import java.util.*;

public class ARRAYLIST {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        // ArrayList<Integer> list = new ArrayList<>();

        // list.add(10);
        // list.add(20);
        // list.add(30);
        // list.add(40);

        // System.out.println(list);

        // System.out.println("ELEMENT AT INDEX 2 : " + list.get(2));

        // list.remove(2);

        // System.out.println(list);

        // list.set(1, 100);

        // System.out.println(list);

        // System.out.println(list.contains(40));

        // list.add(1, 99);

        // System.out.println(list);

        // for (int i = list.size() - 1; i >= 0; i--) {

        // System.out.println(list.get(i));

        // }

        // Collections.sort(list, Collections.reverseOrder());

        // System.out.println(list);

        // ArrayList<ArrayList<Integer>> list_2d = new ArrayList<>();

        // ArrayList<Integer> table = new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(6);
        list.add(5);
        list.add(8);
        // list.add(8);
        // list.add(9);
        // list.add(10);
        // list.add(11);
        // list.add(12);
        System.out.println(list);

        lonlynum(list);
    }

    public static void lonlynum(ArrayList<Integer> list) {

        for (int i = 0; i < list.size(); i++) {

            int num = list.get(i);

            list.remove(i);

            if (!(list.contains(num) || list.contains(num + 1) || list.contains(num - 1))) {

                System.out.println(num + " IS LONLYYYYY");
            }
            
            list.add(i, num);

        }

    }

    public static void twopointer(ArrayList<Integer> list, int key) {

        int p = list.size();

        for (int i = 0; i < list.size() - 1; i++) {

            if (list.get(i) > list.get(i + 1)) {

                p = i;
                break;
            }

        }
        int si = p + 1;
        int ei = p;

        while (si != ei) {

            System.out.println("CHECKING " + list.get(si) + " AND " + list.get(ei));

            if (list.get(si) + list.get(ei) == key) {

                System.out.println(list.get(si) + " + " + list.get(ei));
                si++;

            } else if (list.get(si) + list.get(ei) > key) {

                ei--;
            } else if (list.get(si) + list.get(ei) < key) {

                si++;
            }

            if (ei == -1) {

                ei = list.size() - 1;

            }
            if (si == list.size() - 1) {
                si = 0;

            }

        }

    }

    public static int conatiner(ArrayList<Integer> list) {

        int max = 0;
        int lp = 0;
        int rp = list.size() - 1;

        while (lp < rp) {

            if (lp < rp) {
                lp++;

            } else {
                rp--;
            }

            max = Math.max(max, ((Math.min(list.get(lp), list.get(rp))) * (rp - lp)));

        }

        return max;

    }

}
