import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] line = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = line[0];
        int cols = line[1];

        int[][] matrix = new int[rows][cols];

        fillMatrix(scanner, rows, matrix);

        int searchedNumber = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;


        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int element = matrix[row][col];
                if (searchedNumber == element) {
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }

        if (!isFound) {
            System.out.println("not found");
        }
    }

    private static void fillMatrix(Scanner scanner, int rows, int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = numbers;
        }
    }
}
