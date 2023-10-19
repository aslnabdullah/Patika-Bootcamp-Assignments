package Week2;
import java.util.Scanner;

public class DeseneGoreMetot {
    static boolean exit = true;
    static int firstNumber;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("n sayısı : " );
        int n = scan.nextInt();
        scan.close();
        firstNumber = n;
        System.out.println(reduceTheNumber(n, -5));



    }
    static String reduceTheNumber(int n, int i){
        System.out.print(n + " ");
        n += i;
        if (n == firstNumber){
            return Integer.toString(firstNumber);
        } else if (n <= 0) {
            exit =false;
        }
        return exit ? reduceTheNumber(n,-5) : reduceTheNumber(n , +5);
    }
}
