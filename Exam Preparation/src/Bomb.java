import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        String[] commands = scanner.nextLine().split(",");

        int sapperRow = 0;
        int sapperCol = 0;
        int allBombsInField = 0;

        int sapperBombsFound = 0;

        for (int row = 0; row < size; row++) {
            List<Character> characterList = Arrays.stream(scanner.nextLine().split(" ")).map(e -> e.charAt(0)).collect(Collectors.toList());

            for (int col = 0; col < characterList.size(); col++) {
                char currentChar = characterList.get(col);

                if (currentChar == 's') {
                    sapperRow = row;
                    sapperCol = col;
                } else if (currentChar == 'B') {
                    allBombsInField++;
                }

                matrix[row][col] = currentChar;
            }
        }


        for (int i = 0; i < commands.length; i++) {


            switch (commands[i]) {

                case "left":

                    if (sapperCol != 0) {
                        sapperCol--;
                    }

                    break;

                case "right":

                    if (sapperCol != matrix.length - 1) {
                        sapperCol++;
                    }
                    break;

                case "up":

                    if (sapperRow != 0) {
                        sapperRow--;
                    }
                    break;

                case "down":

                    if (sapperRow != matrix.length - 1) {
                        sapperRow++;
                    }
                    break;

            }


            if (matrix[sapperRow][sapperCol] == 'B') {
                sapperBombsFound++;
                matrix[sapperRow][sapperCol] = '+';
                System.out.println("You found a bomb!");
                if (allBombsInField == sapperBombsFound) {
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            } else if (matrix[sapperRow][sapperCol] == 'e') {
                System.out.printf("END! %d bombs left on the field", allBombsInField - sapperBombsFound);
                return;
            }
        }

        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)" , allBombsInField - sapperBombsFound , sapperRow , sapperCol);


    }
}
