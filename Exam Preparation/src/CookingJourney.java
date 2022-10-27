import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int myRow = 0;
        int myCol = 0;

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            List<Character> characterList = Arrays.stream(scanner.nextLine().split("")).map(e -> e.charAt(0)).collect(Collectors.toList());

            for (int col = 0; col < characterList.size(); col++) {
                char currentChar = characterList.get(col);

                if (currentChar == 'S') {
                    myRow = row;
                    myCol = col;
                }

                matrix[row][col] = currentChar;

            }
        }

        int moneyCollected = 0;


        while (moneyCollected < 50) {
            String line = scanner.nextLine();


            switch (line) {

                case "up":

                    if (myRow - 1 < 0) {
                        System.out.println("Bad news! You are out of the pastry shop.");
                        System.out.printf("Money: %d%n", moneyCollected);
                        matrix[myRow][myCol] = '-';
                        printMatrix(matrix);
                        return;
                    }
                    if (Character.isDigit(matrix[myRow - 1][myCol])) {
                        moneyCollected += Integer.parseInt(String.valueOf(matrix[myRow - 1][myCol]));
                        matrix[myRow][myCol] = '-';
                        myRow--;
                        matrix[myRow][myCol] = 'S';
                    } else if (matrix[myRow - 1][myCol] == 'P') {
                        matrix[myRow][myCol] = '-';
                        matrix[myRow - 1][myCol] = '-';

                        for (int r = 0; r < matrix.length; r++) {
                            for (int c = 0; c < matrix[r].length; c++) {
                                if (matrix[r][c] == 'P') {
                                    myRow = r;
                                    myCol = c;
                                    matrix[myRow][myCol] = 'S';
                                    break;
                                }
                            }
                            if (matrix[myRow][myCol] == 'S') {

                                break;
                            }
                        }
                    } else {
                        myRow--;
                        matrix[myRow + 1][myCol] = '-';
                        matrix[myRow][myCol] = 'S';
                    }

                    break;

                case "down":

                    if (myRow + 1 > matrix.length - 1) {
                        System.out.println("Bad news! You are out of the pastry shop.");
                        System.out.printf("Money: %d%n", moneyCollected);
                        matrix[myRow][myCol] = '-';
                        printMatrix(matrix);
                        return;
                    }
                    if (Character.isDigit(matrix[myRow + 1][myCol])) {
                        moneyCollected += Integer.parseInt(String.valueOf(matrix[myRow + 1][myCol]));
                        matrix[myRow][myCol] = '-';
                        myRow++;
                        matrix[myRow][myCol] = 'S';
                    } else if (matrix[myRow + 1][myCol] == 'P') {
                        matrix[myRow][myCol] = '-';
                        matrix[myRow + 1][myCol] = '-';

                        for (int r = 0; r < matrix.length; r++) {
                            for (int c = 0; c < matrix[r].length; c++) {
                                if (matrix[r][c] == 'P') {
                                    myRow = r;
                                    myCol = c;
                                    matrix[myRow][myCol] = 'S';
                                    break;
                                }
                            }
                            if (matrix[myRow][myCol] == 'S') {

                                break;
                            }
                        }
                    } else {
                        myRow++;
                        matrix[myRow - 1][myCol] = '-';
                        matrix[myRow][myCol] = 'S';
                    }

                    break;

                case "left":

                    if (myCol - 1 < 0) {
                        System.out.println("Bad news! You are out of the pastry shop.");
                        System.out.printf("Money: %d%n", moneyCollected);
                        matrix[myRow][myCol] = '-';
                        printMatrix(matrix);
                        return;
                    }
                    if (Character.isDigit(matrix[myRow][myCol - 1])) {
                        moneyCollected += Integer.parseInt(String.valueOf(matrix[myRow][myCol - 1]));
                        matrix[myRow][myCol] = '-';
                        myCol--;
                        matrix[myRow][myCol] = 'S';
                    } else if (matrix[myRow][myCol - 1] == 'P') {
                        matrix[myRow][myCol] = '-';
                        matrix[myRow][myCol - 1] = '-';

                        for (int r = 0; r < matrix.length; r++) {
                            for (int c = 0; c < matrix[r].length; c++) {
                                if (matrix[r][c] == 'P') {
                                    myRow = r;
                                    myCol = c;
                                    matrix[myRow][myCol] = 'S';
                                    break;
                                }
                            }
                            if (matrix[myRow][myCol] == 'S') {

                                break;
                            }
                        }
                    } else {
                        myCol--;
                        matrix[myRow][myCol + 1] = '-';
                        matrix[myRow][myCol] = 'S';
                    }

                    break;

                case "right":

                    if (myCol + 1 > matrix.length - 1) {
                        System.out.println("Bad news! You are out of the pastry shop.");
                        System.out.printf("Money: %d%n", moneyCollected);
                        matrix[myRow][myCol] = '-';
                        printMatrix(matrix);
                        return;
                    }
                    if (Character.isDigit(matrix[myRow][myCol + 1])) {
                        moneyCollected += Integer.parseInt(String.valueOf(matrix[myRow][myCol + 1]));
                        matrix[myRow][myCol] = '-';
                        myCol++;
                        matrix[myRow][myCol] = 'S';
                    } else if (matrix[myRow][myCol + 1] == 'P') {
                        matrix[myRow][myCol] = '-';
                        matrix[myRow][myCol + 1] = '-';

                        for (int r = 0; r < matrix.length; r++) {
                            for (int c = 0; c < matrix[r].length; c++) {
                                if (matrix[r][c] == 'P') {
                                    myRow = r;
                                    myCol = c;
                                    matrix[myRow][myCol] = 'S';

                                    break;
                                }
                            }
                            if (matrix[myRow][myCol] == 'S') {

                                break;
                            }
                        }
                    } else {
                        myCol++;
                        matrix[myRow][myCol - 1] = '-';
                        matrix[myRow][myCol] = 'S';
                    }

                    break;


            }


        }

        System.out.println("Good news! You succeeded in collecting enough money!");
        System.out.printf("Money: %d%n", moneyCollected);

        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println();
        }
    }


}
