import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");
        int pythonLength = 1;

        char[][] matrix = new char[size][size];

        int pythonRow = 0;
        int pythonCol = 0;


        int foodInTheField = 0;


        for (int row = 0; row < size; row++) {
            List<Character> characterList = Arrays.stream(scanner.nextLine().split(" "))
                    .map(e -> e.charAt(0)).collect(Collectors.toList());

            for (int col = 0; col < characterList.size(); col++) {
                char currentChar = characterList.get(col);

                if (currentChar == 's') {
                    pythonRow = row;
                    pythonCol = col;

                } else if (currentChar == 'f') {

                    foodInTheField++;
                }

                matrix[row][col] = currentChar;
            }

        }


        int eatenFood = 0;

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];

            switch (command) {

                case "up":

                    if (pythonRow == 0) {
                        pythonRow = matrix.length - 1;
                    } else {
                        pythonRow--;
                    }


                    break;

                case "down":

                    if (pythonRow == matrix.length - 1) {
                        pythonRow = 0;
                    } else {
                        pythonRow++;
                    }

                    break;

                case "left":

                    if (pythonCol == 0) {
                        pythonCol = matrix.length - 1;
                    } else {
                        pythonCol--;
                    }

                    break;

                case "right":

                    if (pythonCol == matrix.length - 1) {
                        pythonCol = 0;
                    } else {
                        pythonCol++;
                    }


                    break;
            }

            if (matrix[pythonRow][pythonCol] == 'e') {
                System.out.println("You lose! Killed by an enemy!");
                return;
            } else if (matrix[pythonRow][pythonCol] == 'f') {
                eatenFood++;
                matrix[pythonRow][pythonCol] = '*';
                if (pythonLength + eatenFood > foodInTheField) {
                    System.out.printf("You win! Final python length is %d", pythonLength + eatenFood);
                    return;
                }
            }
        }

        if (eatenFood <= foodInTheField) {
            System.out.printf("You lose! There is still %d food to be eaten.", foodInTheField - eatenFood);
        }

    }
}
