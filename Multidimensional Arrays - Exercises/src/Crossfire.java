import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensionsOfAMatrix = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensionsOfAMatrix[0]);
        int cols = Integer.parseInt(dimensionsOfAMatrix[1]);
        List<List<Integer>> matrix = new ArrayList<>();

        fillMatrix(rows, cols, matrix);

        String line = scanner.nextLine();
        while (!line.equals("Nuke it from orbit")) {
            String[] tokens = line.split(" ");
            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);

            //махаме по редове:започваме от текущия ред - радиус до текущия ред + радиус
            for (int rowToRemove = row - radius; rowToRemove <= row + radius; rowToRemove++) {
                if (isInMatrix(rowToRemove, col, matrix)) {
                    matrix.get(rowToRemove).remove(col);
                }
            }

            //махаме по колони : започваме от текущата колона - радиуса до текущата колона + радиуса
            for (int colToRemove = col + radius; colToRemove >= col - radius; colToRemove--) {
                if (isInMatrix(row, colToRemove, matrix)) {
                    matrix.get(row).remove(colToRemove);
                }
            }

            matrix.removeIf(List::isEmpty);

            line = scanner.nextLine();
        }

        printMatrix(matrix);


    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }



    private static boolean isInMatrix(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void fillMatrix(int rows, int cols, List<List<Integer>> matrix) {
        int counter = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(counter++);
            }
        }
    }
}
