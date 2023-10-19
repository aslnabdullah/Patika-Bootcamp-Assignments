package Week2;

import java.util.Scanner;

public class FindPallindromeWord {
    public static void main(String[] args) {
        boolean control = false;
        System.out.println("lütfen kontrol etmek istediğiniz kelimeyi giriniz.");
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        if (isPallindrome(word)){
            System.out.println("girdiğiniz " + word + " kelimesi pallindrome kelimedir.");
        }
        else {
            System.out.println("Girdiğiniz " +word + " kelimesi pallindrome değildir");
        }


    }
    static boolean isPallindrome(String str){
        String reverse = "";
        for (int i = str.length()-1; i>=0;i--){
            reverse += str.charAt(i);

        }
        return str.equals(reverse);
    }
}
