import java.util.*;

public class que_pra {

    public static void B_num(int num) {

        Queue<Integer> q = new LinkedList<>();

        q.add(1);

        for (int i = 0; i < num; i++) {

            System.out.println(q);

            if (q.peek()==1) {
                
            }

        }

    }

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        B_num(5);

    }

}
