import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //NE E RESHENA PRAVILNO , DAVA MI 60/100

        int energy = Integer.parseInt(scanner.nextLine());
        int rowsSize = Integer.parseInt(scanner.nextLine());

        int parisRow = 0;
        int parisCol = 0;

        char[][] matrix = new char[rowsSize][];


        for (int i = 0; i < rowsSize; i++) {
            char[] array = scanner.nextLine().toCharArray();
            matrix[i] = array;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                char currentChar = matrix[i][j];
                if (currentChar == 'P') {
                    parisRow = i;
                    parisCol = j;
                }
            }
        }

        while (energy > 0) {
            String[] command = scanner.nextLine().split("\\s+");

            String commandName = command[0];
            int spawnRow = Integer.parseInt(command[1]);
            int spawnCol = Integer.parseInt(command[2]);

            matrix[spawnRow][spawnCol] = 'S';

            switch (commandName) {

                case "up":

                    if (parisRow - 1 < 0) {
                        energy--;
                    } else {
                        matrix[parisRow][parisCol] = '-';
                        parisRow--;
                        if (checkIfHelenIsHere(energy, rowsSize, parisRow, parisCol, matrix, spawnRow, spawnCol))
                            return;
                        matrix[parisRow][parisCol] = 'P';
                        energy--;
                    }


                    break;

                case "down":

                    if (parisRow + 1 > matrix.length - 1) {
                        energy--;
                    } else {
                        matrix[parisRow][parisCol] = '-';
                        parisRow++;
                        if (checkIfHelenIsHere(energy, rowsSize, parisRow, parisCol, matrix, spawnRow, spawnCol))
                            return;
                        matrix[parisRow][parisCol] = 'P';
                        energy--;
                    }

                    break;

                case "left":

                    if (parisCol - 1 < 0) {
                        energy--;
                    } else {
                        matrix[parisRow][parisCol] = '-';
                        parisCol--;
                        if (checkIfHelenIsHere(energy, rowsSize, parisRow, parisCol, matrix, spawnRow, spawnCol))
                            return;
                        matrix[parisRow][parisCol] = 'P';
                        energy--;
                    }

                    break;

                case "right":

                    if (parisCol + 1 > matrix.length - 1) {
                        energy--;
                    } else {
                        matrix[parisRow][parisCol] = '-';
                        parisCol++;
                        if (checkIfHelenIsHere(energy, rowsSize, parisRow, parisCol, matrix, spawnRow, spawnCol))
                            return;
                        matrix[parisRow][parisCol] = 'P';
                        energy--;
                    }

                    break;

            }

            if (parisRow == spawnRow && parisCol == spawnCol) {
                energy -= 2;

                if (energy <= 0) {
                    matrix[parisRow][parisCol] = 'X';
                    System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
                    printMatrix(rowsSize, matrix);
                    return;
                } else {
                    matrix[parisRow][parisCol] = '-';
                }
            }


        }

        matrix[parisRow][parisCol] = 'X';
        System.out.printf("Paris died at %d;%d.%n" , parisRow, parisCol);
        printMatrix(rowsSize, matrix);
    }

    private static boolean checkIfHelenIsHere(int energy, int rowsSize, int parisRow, int parisCol, char[][] matrix, int spawnRow, int spawnCol) {
        if (matrix[parisRow][parisCol] == 'H') {
            matrix[spawnRow][spawnCol] = 'S';
            energy--;
            matrix[parisRow][parisCol] = '-';
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
            printMatrix(rowsSize, matrix);
            return true;

        }
        return false;
    }

    private static void printMatrix(int rowsSize, char[][] matrix) {
        for (int row = 0; row < rowsSize; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
