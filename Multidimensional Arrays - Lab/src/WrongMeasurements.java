import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int rows = size;
        int cols = 0;
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = numbers;
            cols = matrix[row].length;
        }


        int[] indexOfWrongValue = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = indexOfWrongValue[0];
        int c = indexOfWrongValue[1];
        int wrongValue = matrix[r][c];
        List<Integer> newValues = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int currentNum = matrix[row][col];

                if (currentNum == wrongValue) {
                    int up = 0;
                    int down = 0;
                    int left = 0;
                    int right = 0;

                    if (row - 1 >= 0 && matrix[row - 1][col] != wrongValue) {
                        up = matrix[row - 1][col];
                    }

                    if (row + 1 < rows && matrix[row + 1][col] != wrongValue) {
                        down = matrix[row + 1][col];
                    }

                    if (col - 1 >= 0 && matrix[row][col - 1] != wrongValue) {
                        left = matrix[row][col - 1];
                    }

                    if (col + 1 < cols && matrix[row][col + 1] != wrongValue) {
                        right = matrix[row][col + 1];
                    }

                    int sum = up + down + left + right;
                    newValues.add(sum);


                }
            }
        }

        fillTheNewValues(rows, cols, matrix, wrongValue, newValues);


        printMatrix(rows, cols, matrix);


    }

    private static void printMatrix(int rows, int cols, int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");

            }
            System.out.println();
        }
    }

    private static void fillTheNewValues(int rows, int cols, int[][] matrix, int wrongValue, List<Integer> newValues) {
        int count = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (matrix[row][col] == wrongValue) {
                    matrix[row][col] = newValues.get(count);
                    count++;
                }
            }
        }
    }


}
