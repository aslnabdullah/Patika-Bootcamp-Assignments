package Week2;
import java.util.Scanner;
public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir sayı girin: ");
        int sayi = scanner.nextInt();

        if (sayi <= 1) {
            System.out.println(sayi + " asal bir sayı değildir.");
        } else {
            if (asalMi(sayi, 2)) {
                System.out.println(sayi + " asal bir sayıdır.");
            } else {
                System.out.println(sayi + " asal bir sayı değildir.");
            }
        }
    }

    // Recursive olarak asal sayı kontrolü
    static boolean asalMi(int sayi, int bölen) {
        if (bölen * bölen > sayi) {
            return true;
        }
        if (sayi % bölen == 0) {
            return false;
        }
        return asalMi(sayi, bölen + 1);


    }
}
