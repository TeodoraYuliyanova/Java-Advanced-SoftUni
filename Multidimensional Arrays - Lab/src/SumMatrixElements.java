import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensionsOfTheMatrix = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(dimensionsOfTheMatrix[0]);
        int cols = Integer.parseInt(dimensionsOfTheMatrix[1]);

        int[][] matrix = new int[rows][cols];
        fillMatrix(scanner, rows, cols, matrix);

        int sum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int element = matrix[row][col];
                sum += element;
            }
        }

        System.out.println(rows);
        System.out.println(cols);
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
