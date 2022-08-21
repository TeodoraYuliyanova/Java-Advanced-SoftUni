import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());


        String[][] matrix1 = new String[rows][cols];
        fillMatrix1(scanner, rows, matrix1);


        String[][] matrix2 = new String[rows][cols];
        fillMatrix2(scanner, rows, matrix2);


        String[][] finalMatrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String element1 = matrix1[row][col];
                String element2 = matrix2[row][col];
                String toBeAdded = "*";

                if (!element1.equals(element2)) {
                    finalMatrix[row][col] = toBeAdded;
                } else {
                    finalMatrix[row][col] = element1;
                }


            }
        }


        printFinalMatrix(rows, cols, finalMatrix);

    }

    private static void printFinalMatrix(int rows, int cols, String[][] finalMatrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(finalMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix2(Scanner scanner, int rows, String[][] matrix2) {
        for (int row = 0; row < rows; row++) {
            String[] numbersForSecondMatrix = scanner.nextLine().split(" ");
            matrix2[row] = numbersForSecondMatrix;
        }
    }

    private static void fillMatrix1(Scanner scanner, int rows, String[][] matrix1) {
        for (int row = 0; row < rows; row++) {
            String[] numbersForFirstMatrix = scanner.nextLine().split(" ");
            matrix1[row] = numbersForFirstMatrix;
        }
    }
}
