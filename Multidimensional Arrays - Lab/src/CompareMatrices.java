import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] line1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rowsFirstMatrix = line1[0];
        int colsFirstMatrix = line1[1];

        int[][] matrix1 = new int[rowsFirstMatrix][colsFirstMatrix];
        fillMatrix1(scanner, rowsFirstMatrix, matrix1);


        int[] line2 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rowsSecondMatrix = line2[0];
        int colsSecondMatrix = line2[1];

        int[][] matrix2 = new int[rowsSecondMatrix][colsSecondMatrix];
        fillMatrix2(scanner, rowsSecondMatrix, matrix2);


        if ((rowsFirstMatrix != rowsSecondMatrix) || (colsFirstMatrix != colsSecondMatrix)) {
            System.out.println("not equal");
        } else {
            boolean areEqual = true;
            for (int row = 0; row < rowsFirstMatrix; row++) {
                for (int col = 0; col < colsFirstMatrix; col++) {

                    if (matrix1[row][col] != matrix2[row][col]) {
                        areEqual = false;
                        break;
                    }
                }
            }

            if (areEqual) {
                System.out.println("equal");
            } else {
                System.out.println("not equal");
            }
        }

    }

    private static void fillMatrix2(Scanner scanner, int rowsSecondMatrix, int[][] matrix2) {
        for (int row = 0; row < rowsSecondMatrix; row++) {
            int[] numbersForSecondMatrix = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix2[row] = numbersForSecondMatrix;
        }
    }

    private static void fillMatrix1(Scanner scanner, int rowsFirstMatrix, int[][] matrix1) {
        for (int row = 0; row < rowsFirstMatrix; row++) {
            int[] numbersForFirstMatrix = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix1[row] = numbersForFirstMatrix;
        }
    }
}
