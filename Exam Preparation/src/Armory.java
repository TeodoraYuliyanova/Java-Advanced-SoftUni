import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        int officerRow = 0;
        int officerCol = 0;

        for (int row = 0; row < size; row++) {
            List<Character> characterList = Arrays.stream(scanner.nextLine().split("")).map(e -> e.charAt(0)).collect(Collectors.toList());

            for (int col = 0; col < characterList.size(); col++) {
                char currentChar = characterList.get(col);

                if (currentChar == 'A') {
                    officerRow = row;
                    officerCol = col;
                }

                matrix[row][col] = currentChar;
            }
        }


        int money = 0;

        while (money < 65) {
            String line = scanner.nextLine();

            switch (line) {

                case "up":

                    if (officerRow - 1 < 0) {
                        System.out.println("I do not need more swords!");
                        System.out.printf("The king paid %d gold coins.%n", money);
                        matrix[officerRow][officerCol] = '-';
                        printMatrix(size, matrix);
                        return;
                    }

                    if (Character.isDigit(matrix[officerRow - 1][officerCol])) {
                        money += Integer.parseInt(String.valueOf(matrix[officerRow - 1][officerCol]));
                        matrix[officerRow][officerCol] = '-';
                        officerRow--;
                        matrix[officerRow][officerCol] = 'A';
                    }else if (matrix[officerRow - 1][officerCol] == 'M') {
                        matrix[officerRow][officerCol] = '-';
                        matrix[officerRow - 1][officerCol] = '-';

                        for (int r = 0; r < matrix.length; r++) {
                            for (int c = 0; c < matrix[r].length; c++) {
                                if (matrix[r][c] == 'M') {
                                    officerRow = r;
                                    officerCol = c;
                                    matrix[officerRow][officerCol] = 'A';
                                    break;
                                }
                            }
                            if (matrix[officerRow][officerCol] == 'A') {

                                break;
                            }
                        }
                    }else {
                        officerRow--;
                        matrix[officerRow + 1][officerCol] = '-';

                    }

                    break;

                case "down":

                    if (officerRow + 1 >= matrix.length) {
                        System.out.println("I do not need more swords!");
                        System.out.printf("The king paid %d gold coins.%n", money);
                        matrix[officerRow][officerCol] = '-';
                        printMatrix(size, matrix);
                        return;
                    }

                    if (Character.isDigit(matrix[officerRow + 1][officerCol])) {
                        money += Integer.parseInt(String.valueOf(matrix[officerRow + 1][officerCol]));
                        matrix[officerRow][officerCol] = '-';
                        officerRow++;
                        matrix[officerRow][officerCol] = 'A';
                    }else if (matrix[officerRow + 1][officerCol] == 'M') {
                        matrix[officerRow][officerCol] = '-';
                        matrix[officerRow + 1][officerCol] = '-';

                        for (int r = 0; r < matrix.length; r++) {
                            for (int c = 0; c < matrix[r].length; c++) {
                                if (matrix[r][c] == 'M') {
                                    officerRow = r;
                                    officerCol = c;
                                    matrix[officerRow][officerCol] = 'A';
                                    break;
                                }
                            }
                            if (matrix[officerRow][officerCol] == 'A') {

                                break;
                            }
                        }
                    }else {
                        officerRow++;
                        matrix[officerRow - 1][officerCol] = '-';

                    }

                    break;

                case "left":

                    if (officerCol - 1 < 0) {
                        System.out.println("I do not need more swords!");
                        System.out.printf("The king paid %d gold coins.%n", money);
                        matrix[officerRow][officerCol] = '-';
                        printMatrix(size, matrix);
                        return;
                    }

                    if (Character.isDigit(matrix[officerRow][officerCol - 1])) {
                        money += Integer.parseInt(String.valueOf(matrix[officerRow][officerCol - 1]));
                        matrix[officerRow][officerCol] = '-';
                        officerCol--;
                        matrix[officerRow][officerCol] = 'A';
                    }else if (matrix[officerRow][officerCol - 1] == 'M') {
                        matrix[officerRow][officerCol] = '-';
                        matrix[officerRow][officerCol - 1] = '-';

                        for (int r = 0; r < matrix.length; r++) {
                            for (int c = 0; c < matrix[r].length; c++) {
                                if (matrix[r][c] == 'M') {
                                    officerRow = r;
                                    officerCol = c;
                                    matrix[officerRow][officerCol] = 'A';
                                    break;
                                }
                            }
                            if (matrix[officerRow][officerCol] == 'A') {

                                break;
                            }
                        }
                    } else {
                        officerCol--;
                        matrix[officerRow][officerCol + 1] = '-';

                    }

                    break;

                case "right":

                    if (officerCol + 1 >= matrix.length) {
                        System.out.println("I do not need more swords!");
                        System.out.printf("The king paid %d gold coins.%n", money);
                        matrix[officerRow][officerCol] = '-';
                        printMatrix(size, matrix);
                        return;
                    }

                    if (Character.isDigit(matrix[officerRow][officerCol + 1])) {
                        money += Integer.parseInt(String.valueOf(matrix[officerRow][officerCol + 1]));
                        matrix[officerRow][officerCol] = '-';
                        officerCol++;
                        matrix[officerRow][officerCol] = 'A';
                    }else if (matrix[officerRow][officerCol + 1] == 'M') {
                        matrix[officerRow][officerCol] = '-';
                        matrix[officerRow][officerCol + 1] = '-';

                        for (int r = 0; r < matrix.length; r++) {
                            for (int c = 0; c < matrix[r].length; c++) {
                                if (matrix[r][c] == 'M') {
                                    officerRow = r;
                                    officerCol = c;
                                    matrix[officerRow][officerCol] = 'A';
                                    break;
                                }
                            }
                            if (matrix[officerRow][officerCol] == 'A') {

                                break;
                            }
                        }
                    } else {
                        officerCol++;
                        matrix[officerRow][officerCol - 1] = '-';

                    }

                    break;

            }

        }

        System.out.println("Very nice swords, I will come back for more!");
        System.out.printf("The king paid %d gold coins.%n", money);
        printMatrix(size, matrix);
    }

    private static void printMatrix(int size, char[][] matrix) {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
