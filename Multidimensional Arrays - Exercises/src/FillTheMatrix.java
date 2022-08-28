import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(", ");

        int size = Integer.parseInt(line[0]);
        String pattern = line[1];

        int rows = size;
        int cols = size;
        int[][] matrix = new int[size][size];

        switch (pattern) {

            case "A":

                fillPatternA(matrix, rows, cols);


                printMatrix(matrix, rows, cols);

                break;


            case "B":

                fillPatternB(size, matrix, rows, cols);

                printMatrix(matrix, rows, cols);
                break;


        }

    }

    public static void printMatrix(int[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void fillPatternB(int size, int[][] matrix, int rows, int cols) {
        int counter2 = 1;
        for (int col = 0; col < cols; col++) {
            if (col % 2 == 0) {

                for (int row = 0; row < rows; row++) {
                    matrix[row][col] = counter2;
                    counter2++;
                }
            } else {

                for (int row = size - 1; row >= 0; row--) {
                    matrix[row][col] = counter2;
                    counter2++;
                }

            }
        }
    }

    public static void fillPatternA(int[][] matrix, int rows, int cols) {
        int counter = 1;
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                matrix[row][col] = counter;
                counter++;
            }
        }
    }
}
