import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        int thiefRow = 0;
        int thiefCol = 0;

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            List<Character> characterList = Arrays.stream(scanner.nextLine().split(" ")).map(e -> e.charAt(0)).collect(Collectors.toList());

            for (int col = 0; col < characterList.size(); col++) {
                char current = characterList.get(col);

                if (current == 'D') {
                    thiefRow = row;
                    thiefCol = col;
                }
                matrix[row][col] = current;
            }
        }

        int stolenMoney = 0;

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];

            matrix[thiefRow][thiefCol] = '+';

            switch (command) {

                case "up":
                    if (thiefRow - 1 < 0) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        thiefRow--;

                    }
                    break;

                case "down":
                    if (thiefRow + 1 > matrix.length - 1) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        thiefRow++;

                    }
                    break;

                case "left":
                    if (thiefCol - 1 < 0) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        thiefCol--;

                    }
                    break;

                case "right":
                    if (thiefCol + 1 > matrix.length - 1) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        thiefCol++;
                    }
                    break;


            }

            if (matrix[thiefRow][thiefCol] == '$') {
                stolenMoney += thiefRow * thiefCol;
                matrix[thiefRow][thiefCol] = '+';
                System.out.printf("You successfully stole %d$.%n", thiefRow * thiefCol);
            } else if (matrix[thiefRow][thiefCol] == 'P') {
                System.out.printf("You got caught with %d$, and you are going to jail.%n", stolenMoney);
                matrix[thiefRow][thiefCol] = '#';
                printMatrix(size, matrix);
                return;
            }

        }
        System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n" , stolenMoney);
        matrix[thiefRow][thiefCol] = 'D';
        printMatrix(size, matrix);
    }

    private static void printMatrix(int size, char[][] matrix) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
