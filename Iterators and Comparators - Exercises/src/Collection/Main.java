package Collection;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListyOperator listyOperator = null;

        String line = scanner.nextLine();
        while (!line.equals("END")) {

            String[] commandParts = line.split("\\s+");
            String command = commandParts[0];

            switch (command) {

                case "Create":
                    if (commandParts.length > 1) {
                        listyOperator = new ListyOperator(Arrays.copyOfRange(commandParts, 1, commandParts.length));
                    } else {
                        listyOperator = new ListyOperator();
                    }

                    break;

                case "HasNext":
                    System.out.println(listyOperator.HasNext());

                    break;

                case "Move":
                    System.out.println(listyOperator.Move());

                    break;

                case "Print":
                    try {
                        listyOperator.Print();
                    } catch (IllegalStateException exception) {
                        System.out.println("Invalid Operation");
                    }

                    break;

                case "PrintAll":

                    for (String element : listyOperator) {
                        System.out.print(element + " ");
                    }
                    System.out.println();


                    break;

            }


            line = scanner.nextLine();
        }
    }
}
