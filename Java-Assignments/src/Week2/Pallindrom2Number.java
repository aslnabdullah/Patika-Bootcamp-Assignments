package Week2;
import java.util.Scanner;

public class Pallindrom2Number {
    static boolean isPallindrom(int number){
        int temp = number,reverseNumber = 0, lastNumber;//sayı üzerinde işlem yapmamak için temp girdisi yapıp sayıya eşitledik
        System.out.println("sayı => " + temp);        //reverseNumber da her döngü turunda sondaki basamğı ekliyoruz sırayla
        while (temp != 0 ){

            lastNumber = temp % 10; //burada sayının son basamağını buluyoruz
            reverseNumber = reverseNumber*10 + lastNumber;  // burada son basamaktaki sayıları sırayla 10 la çarpıyrouz
            temp = temp/ 10;                                  //en başa gelebilsin diye
        }
        System.out.println("dönüştürülmüş sayı : " + reverseNumber);

        if (reverseNumber == number){
            System.out.println("true");
            return true;

        }
        else {
            System.out.println("false");
            return false;
        }


    }


    public static void main(String[] args) {
        isPallindrom(123321);

    }
}
