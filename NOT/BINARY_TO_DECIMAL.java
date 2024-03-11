import java.util.*;

public class BINARY_TO_DECIMAL{

    public static int binary_to_decimal(int binary) {

        int power = 0;
        int decimal = 0;

        while (binary != 0) {
            int last_num = binary % 10;
            decimal = decimal + last_num * (int) Math.pow(2, power);
            power++;
            binary /= 10;

        }

        return decimal;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("ENTER NUM : ");
        int num = sc.nextInt();

        System.out.println(binary_to_decimal(num));
    }

}