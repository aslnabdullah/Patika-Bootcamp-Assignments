package Week2;
import java.util.Scanner;
public class UsluSayiRecursive {
    static int power(int a, int b){

        if (b == 0){ //fonksiyonun döngüsünü bitirmek için burada bu işlemi yapıyoruz
            return 1;
        }
        if (a==1){   //taban 1 e eşitse her zaman 1 döndürecek
            return 1;
        }

        return a*power(a,b-1); //burada da fonksiyonun asıl döngüsü mevcut

    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("lütfen tabandaki sayıyı giriniz.");
        int a = scan.nextInt();
        System.out.println("lütfen üsteki sayıyı giriniz.");
        int b = scan.nextInt();
        System.out.println(power(a,b)); //burada fonksiyonu çağırıyoruz



    }
}
