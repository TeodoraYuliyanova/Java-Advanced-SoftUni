import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(line[0]);
        int cols = Integer.parseInt(line[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                char outsideLetter = (char) ('a' + row);
                char middleLetter = (char) (outsideLetter + col);
                matrix[row][col] = String.valueOf(outsideLetter) + middleLetter + outsideLetter;
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }


    }
}
