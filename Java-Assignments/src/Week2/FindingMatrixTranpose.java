package Week2;

public class FindingMatrixTranpose {

    public static void main(String[] args) {
        int[][] matris = {
                {1,3,5},
                {2,4,6},
                {6,8,9},
                {3,7,2}
        };

        int lines = matris.length;
        int columns = matris[0].length;

        int [][] tranpozMatris = new int[columns][lines];

        for (int i =0;i<lines;i++){
            for (int j = 0;j<columns;j++){
                tranpozMatris[j][i] = matris[i][j];
            }
        }
        System.out.println("Matris : ");
        printMatris(matris);

        System.out.println();

        System.out.println("Tranpose Matris : ");
        printMatris(tranpozMatris);


    }

    public static void printMatris(int[][] matris){
        for(int i =0;i<matris.length;i++){
            for(int j = 0;j<matris[i].length;j++){
                System.out.print(matris[i][j] + " ");
            }
            System.out.println();
        }

    }

}
