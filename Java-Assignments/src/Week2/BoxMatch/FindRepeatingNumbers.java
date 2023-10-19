package Week2.BoxMatch;

public class FindRepeatingNumbers {
    static boolean isFind(int[] arr, int val){
        for(int i : arr){
            if (i == val){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int [] list = {3,5,8,3,6,9,11,8,7,5,3};
        int[] duplicate = new int[list.length];
        int startIndex = 0;

        for (int i = 0; i<list.length;i++){
            for (int j = 0;j<list.length;j++){
                if ((i != j)&& (list[i] == list[j] )){
                    if (isFind(duplicate,list[i])){
                        duplicate[startIndex ++] = list[i];
                    }
                }
            }
        }
        for (int val  : duplicate){
            if ((val != 0) && (val % 2 == 0)){
                System.out.println(val);
            }
        }
    }
}
