import java.util.*;

public class PRA {

    public static void numSquares(int n) {

        int Psqu[] = new int[316];

        int j=0;

        for (int i = 0; i < Psqu.length; i++) {

            Psqu[i] = ++j * j;

        }

        for (int i = 0; i < Psqu.length; i++) {

            System.out.println(i+" "  +Psqu[i]);        }
    }

    public static void main(String[] args) {

        System.out.println("------");

        numSquares(0);
    }
}
