import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//NE E RESHENA PRAVILNO
public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        int mouseRow = 0;
        int mouseCol = 0;

        for (int row = 0; row < size; row++) {
            List<Character> characterList = Arrays.stream(scanner.nextLine().split("")).map(e -> e.charAt(0)).collect(Collectors.toList());

            for (int col = 0; col < characterList.size(); col++) {
                char currentChar = characterList.get(col);

                if (currentChar == 'M') {
                    mouseRow = row;
                    mouseCol = col;
                }
                matrix[row][col] = currentChar;
            }
        }

        int eatenCheese = 0;

        String line = scanner.nextLine();
        while (!line.equals("end")) {

            matrix[mouseRow][mouseCol] = '-';

            switch (line) {


                case "up":

                    if (mouseRow - 1 < 0) {
                        printOutOfBounds(eatenCheese, size, matrix);
                        return;
                    } else {
                        mouseRow--;
                    }

                    if (matrix[mouseRow][mouseCol] == 'B') {
                        mouseRow--;
                    }

                    break;

                case "down":

                    if (mouseRow + 1 > matrix.length - 1) {
                        printOutOfBounds(eatenCheese, size, matrix);
                        return;
                    } else {
                        mouseRow++;
                    }

                    if (matrix[mouseRow][mouseCol] == 'B') {
                        mouseRow++;
                    }

                    break;

                case "left":

                    if (mouseCol - 1 < 0) {
                        printOutOfBounds(eatenCheese, size, matrix);
                        return;
                    } else {
                        mouseCol--;
                    }

                    if (matrix[mouseRow][mouseCol] == 'B') {
                        mouseCol--;
                    }

                    break;

                case "right":

                    if (mouseCol + 1 > matrix.length - 1) {
                        printOutOfBounds(eatenCheese, size, matrix);
                        return;
                    } else {
                        mouseCol++;
                    }

                    if (matrix[mouseRow][mouseCol] == 'B') {
                        mouseCol++;
                    }
                    break;

            }

            if (matrix[mouseRow][mouseCol] == 'c') {
                eatenCheese++;
            }

            matrix[mouseRow][mouseCol] = 'M';


            line = scanner.nextLine();
        }

        if (eatenCheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!", eatenCheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - eatenCheese);
        }


        printMatrix(size, matrix);
    }

    private static void printMatrix(int size, char[][] matrix) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void printOutOfBounds(int eatenCheese, int size, char[][] matrix) {
        System.out.println("Where is the mouse?");
        if (eatenCheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!", eatenCheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - eatenCheese);
        }
        printMatrix(size, matrix);

    }
}
