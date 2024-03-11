public class trapped_water {

    public static void t_w(int arr[]) {

        int ans = 0;

        int l_m_b[] = new int[arr.length];
        int r_m_b[] = new int[arr.length];

        int l_m = arr[0];

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] >= l_m) {

                l_m_b[i] = arr[i];
                l_m = arr[i];

            } else {

                l_m_b[i] = l_m;

            }
        }

        int r_m = arr[arr.length - 1];

        for (int i = arr.length - 1; i >= 0; i--) {

            if (arr[i] >= r_m) {

                r_m_b[i] = arr[i];
                r_m = arr[i];

            } else {

                r_m_b[i] = r_m;

            }
        }

        for (int i = 0; i < r_m_b.length; i++) {

            System.out.print(l_m_b[i] + "   ");

        }
        System.out.println("--");

        for (int i = 0; i < r_m_b.length; i++) {

            System.out.print(r_m_b[i] + "   ");

        }

        for (int i = 1; i < r_m_b.length - 1; i++) {

            ans = ans + Math.min(l_m_b[i], r_m_b[i]) - arr[i];

        }

        System.out.println("T_W = " + ans);

    }

    public static void main(String args[]) {

        int arr[] = { 4, 2, 0, 6, 3, 2, 5 };

        t_w(arr);

    }

}
