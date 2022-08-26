import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
        int rows = sizeOfMatrix;
        int cols = sizeOfMatrix;


        for (int row = 0; row < sizeOfMatrix; row++) {

            int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int col = 0; col < cols; col++) {

                matrix[row][col] = numbers[col];
            }

        }

        int primaryDiagonalSum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (row == col) {
                    primaryDiagonalSum += matrix[row][col];
                }
            }
        }

        int secondaryDiagonalSum = 0;
        for (int row = 0; row < rows; row++) {

            int numToAdd = matrix[row][sizeOfMatrix - 1 - row];

            secondaryDiagonalSum += numToAdd;


        }

        int result = Math.abs(primaryDiagonalSum - secondaryDiagonalSum);
        System.out.println(result);


    }
}
