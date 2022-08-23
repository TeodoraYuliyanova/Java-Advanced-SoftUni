import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensionsOfTheMatrix = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(dimensionsOfTheMatrix[0]);
        int cols = Integer.parseInt(dimensionsOfTheMatrix[1]);

        int[][] matrix = new int[rows][cols];
        fillMatrix(scanner, rows, cols, matrix);


        int sum = Integer.MIN_VALUE;
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;


        for (int row = 0; row <= rows - 1; row++) {
            for (int col = 0; col <= cols - 1; col++) {


                if ((row >= 0 && row < rows - 1) && (col >= 0 && col < cols - 1)) {
                    int firstNum = matrix[row][col] + matrix[row][col + 1];
                    int secondNum = matrix[row + 1][col] + matrix[row + 1][col + 1];
                    int result = firstNum + secondNum;
                    if (result > sum) {
                        sum = result;
                        num1 = matrix[row][col];
                        num2 = matrix[row][col + 1];
                        num3 = matrix[row + 1][col];
                        num4 = matrix[row + 1][col + 1];


                    }
                }
            }
        }

        System.out.println(num1 + " " + num2);
        System.out.println(num3 + " " + num4);
        System.out.println(sum);

    }


    private static void fillMatrix(Scanner scanner, int rows, int cols, int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            String[] numbersForMatrix = scanner.nextLine().split(", ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(numbersForMatrix[col]);
            }
        }
    }
}
