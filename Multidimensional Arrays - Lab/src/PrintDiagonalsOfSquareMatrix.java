import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int rows = size;
        int cols = size;

        int[][] matrix = new int[rows][cols];

        fillMatrix(scanner, rows, matrix);


        firstDiagonal(rows, cols, matrix);

        System.out.println();

        secondDiagonal(rows, cols, matrix);


    }

    private static void secondDiagonal(int rows, int cols, int[][] matrix) {
        for (int col = 0; col < cols; col++) {
            for (int row = rows - 1; row >= 0; row--) {

                System.out.print(matrix[row][col] + " ");
                col++;
            }
        }
    }

    private static void firstDiagonal(int rows, int cols, int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int element = matrix[row][col];

                if (row == col) {
                    System.out.print(element + " ");
                }
            }
        }
    }

    private static void fillMatrix(Scanner scanner, int rows, int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            matrix[row] = numbers;
        }
    }
}
