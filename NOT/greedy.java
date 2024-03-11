import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class greedy {

    public static int activity(int start[], int end[]) {

        int total = 1;

        int i = 0;
        int j = 1;

        while (i < start.length - 1 && j < start.length - 1) {

            System.out.println("checking " + end[i] + " " + start[j]);

            if (end[i] <= start[j]) {
                System.out.println("chossed " + j);

                total++;

                i = j;
            }
            j++;

        }

        return total;

    }

    public static void knapsack(int cap, int wei[], int pri[]) {

        int max_p = 0;
        float rat[] = new float[pri.length];

        for (int i = 0; i < rat.length; i++) {

            rat[i] = pri[i] / wei[i];

        }

        for (int i = 0; i < rat.length - 1; i++) {

            if (rat[i] < rat[i + 1]) {
                float temp = rat[i];
                rat[i] = rat[i + 1];
                rat[i + 1] = temp;

                int temp2 = wei[i];
                wei[i] = wei[i + 1];
                wei[i + 1] = temp2;

                int temp3 = pri[i];
                pri[i] = pri[i + 1];
                pri[i + 1] = temp3;
            }

        }

        for (int i = 0; i < rat.length; i++) {

            System.out.println(rat[i] + " " + wei[i] + " " + pri[i]);

        }

        for (int i = 0; i < rat.length; i++) {

            if (cap >= wei[i]) {

                max_p += pri[i];
                cap -= wei[i];

            } else {

                max_p += rat[i] * cap;
                cap = 0;
                break;
            }

        }
        System.out.println(max_p);

    }

    private static void reverseArray(int[] array) {
        int length = array.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = array[i];
            array[i] = array[length - i - 1];
            array[length - i - 1] = temp;
        }
    }

    public static void A_diff(int a[], int b[]) {

        Arrays.sort(a);
        Arrays.sort(b);

        int sum = 0;

        for (int i = 0; i < b.length; i++) {

            System.out.println(a[i] - b[i]);

            if (a[i] - b[i] < 0) {
                sum += (a[i] - b[i]) / -1;
            } else {
                sum += (a[i] - b[i]);
            }
        }

        System.out.println(sum);

    }

    public static void indian_coin(int val) {

        int curre[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };

        int i = 0;
        int total = 0;

        while (val != 0) {

            if (val >= curre[i]) {
                i++;
            } else {

                val -= curre[--i];
                System.out.println("choosed " + curre[i]);
                total++;
                i = 0;
            }

        }

    }

    public static void chocola(int ver_c[], int hor_c[]) {

        Arrays.sort(hor_c);

        Arrays.sort(ver_c);

        reverseArray(hor_c);
        reverseArray(ver_c);

        int t_h_c = 1;
        int t_v_c = 1;

        int cost = 0;

        int i = 0;
        int j = 0;

        for (i = 0, j = 0; i < hor_c.length && j < ver_c.length;) {

            if (hor_c[i] <= ver_c[j]) {

                System.out.println("CUT OF VER " + ver_c[j] + " TIMES : " + t_h_c);

                cost += ver_c[j] * t_h_c;
                t_v_c++;
                j++;

            } else {

                System.out.println("CUT OF HOR " + hor_c[i] + " TIMES : " + t_v_c);
                cost += hor_c[i] * t_v_c;
                t_h_c++;
                i++;
            }
            System.out.println("COST : " + cost);

        }

        while (i < hor_c.length) {

            System.out.println("CUT OF HOR " + hor_c[i] + " TIMES : " + t_v_c);
            cost += hor_c[i] * t_v_c;
            t_h_c++;
            i++;
        }
        while (j < ver_c.length) {

            System.out.println("CUT OF VER " + ver_c[j] + " TIMES : " + t_h_c);

            cost += ver_c[j] * t_h_c;
            t_v_c++;
            j++;
        }

        System.out.println(cost);
    }

    public static void main(String[] args) {

        int start[] = { 4, 3, 2, 1, 1 };
        int end[] = { 4, 2, 1 };

        // System.out.println(
        // activity(start, end));

        // knapsack(50, end, start);

        // A_diff(start, end);

        // indian_coin(153);

        chocola(start, end);

    }

}
