package Week2;
import java.util.Scanner;
import java.util.Arrays;

public class ArraysMaxMinValues {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("please enter your number");
        int a = scan.nextInt();

        int[] list = {10,23,54,42,7,9,36,65,79};
        Arrays.sort(list);
        for (int i = 0;i<list.length;i++){
            if (list[0] > a){
                System.out.println("girdiğiniz sayıdan daha küçük bir sayı yoktur.");
                System.out.println("girilen sayıdan büyük en küçük sayı : " + list[0]);
                break;
            } else if (list[i] > a) {
                System.out.println("Girilen sayıdan büyük en küçük sayı : " + list[i]);
                System.out.println("Girilen sayıdan küçük en büyük sayı : " + list[i-1]);
                break;
            }
        }







        /*int minVal = list[0];
        int maxVal = list[0];

        for(int i : list){
            if (i < minVal){
                minVal = i;
            }
            if (i > maxVal){
                maxVal = i;
            }

        }
        System.out.println("Minimum Değer : " + minVal);
        System.out.println("Maximum Değer : " + maxVal);*/
    }
}
