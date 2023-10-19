package Week2;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(100);

        Scanner input = new Scanner(System.in);
        int right = 0;
        int selected;
        int[] wrong = new int[5];
        boolean isWin = false;
        boolean isWrong = false;

        System.out.println(number);
        while (right<5){
            System.out.println("please enter your guess.");
            selected = input.nextInt();

            if (selected<0 || selected>99){
                System.out.println("please enter a value between 0 and 100 ");
                if (isWrong){
                    right++;
                    System.out.println("çok fazla hatalı giriş yaptınız. Kalan hak : " + (5-right));
                }
                else {
                    isWrong = true;
                    System.out.println("Bir daha hatalı giriş yaparsanız hakkınızdan düşülecektir.");
                }
                continue;
            }
            if (selected == number){
                System.out.println("tebrikler! doğru tahmin. Tahmin ettğiniz sayı " + number);
                isWin = true;
                break;
            }
            else {
                System.out.println("hatalı bir sayı girdiniz.");
                if (selected > number){
                    System.out.println(selected + " sayısı gizli sayıdan büyüktür.");
                }
                else {
                    System.out.println(selected + " sayısı gizli sayıdan küçüktür.");
                }
                wrong[right++] = selected;
                System.out.println("Kalana hakkınız : " + (5-right));
            }
        }
        if (!isWin){
            System.out.println("Kaybettiniz!");
            if (!isWrong){
                System.out.println("Tahminleriniz " + Arrays.toString(wrong));
            }
        }
    }
}
