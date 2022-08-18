import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < numberOfCommands; i++) {

            String[] line = scanner.nextLine().split("\\s+");

            String command = line[0];

            switch (command) {

                case "1":
                    int elementToPush = Integer.parseInt(line[1]);
                    numbers.push(elementToPush);

                    break;

                case "2":
                    numbers.pop();
                    break;

                case "3":
                    System.out.println(Collections.max(numbers));
                    break;
            }
        }
    }
}
