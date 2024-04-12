public class trapped_water {

    public static void t_w(int height[]) {

        int ans = 0;

        int l_m_b[] = new int[height.length];
        int r_m_b[] = new int[height.length];

        int l_m = height[0];

        for (int i = 0; i < height.length; i++) {

            if (height[i] >= l_m) {

                l_m_b[i] = height[i];
                l_m = height[i];

            } else {

                l_m_b[i] = l_m;

            }
        }

        int r_m = height[height.length - 1];

        for (int i = height.length - 1; i >= 0; i--) {

            if (height[i] >= r_m) {

                r_m_b[i] = height[i];
                r_m = height[i];

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

            ans = ans + Math.min(l_m_b[i], r_m_b[i]) - height[i];

        }

        System.out.println("T_W = " + ans);

    }

    public static void main(String args[]) {

        int height[] = {4,2,0,3,2,5};

        t_w(height);

    }

}
