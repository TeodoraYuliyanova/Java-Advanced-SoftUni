import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(line[0]);
        int cols = Integer.parseInt(line[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] numbers = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = numbers[col];

            }
        }

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split(" ");
            if (tokens.length != 5) {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }

            String command = tokens[0];
            if (!command.equals("swap")) {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            } else {
                int row1 = Integer.parseInt(tokens[1]);
                int col1 = Integer.parseInt(tokens[2]);
                int row2 = Integer.parseInt(tokens[3]);
                int col2 = Integer.parseInt(tokens[4]);

                if ((row1 > rows || col1 > cols) || (row2 > rows || col2 > cols)) {
                    System.out.println("Invalid input!");
                    input = scanner.nextLine();
                    continue;
                } else {
                    String oldElement = matrix[row1][col1];
                    String newElement = matrix[row2][col2];

                    matrix[row2][col2] = oldElement;
                    matrix[row1][col1] = newElement;


                    for (int row = 0; row < rows; row++) {
                        for (int col = 0; col < cols; col++) {
                            System.out.print(matrix[row][col] + " ");
                        }
                        System.out.println();
                    }


                }


            }


            input = scanner.nextLine();
        }
    }
}
