import java.util.*;

public class DECIMAL_TO_BINARY {

    public static int decimal_to_binary(int decimal) {

        int binary = 0;
        int pow = 0;

        while (decimal > 0) {
            int rem = decimal % 2;
            binary = binary + (rem * (int) (Math.pow(10, pow)));

            pow++;
            decimal /= 2;
        }
        return binary;

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("ENTER NUM : ");
        int num = sc.nextInt();

        System.out.println(decimal_to_binary(num));
    }

}