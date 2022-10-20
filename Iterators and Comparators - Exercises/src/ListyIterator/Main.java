package ListyIterator;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListyIterator listyIterator = null;

        String line = scanner.nextLine();
        while (!line.equals("END")) {

            String[] commandParts = line.split(" ");
            String command = commandParts[0];

            switch (command) {

                case "Create":

                    listyIterator = new ListyIterator(Arrays.copyOfRange(commandParts, 1, commandParts.length));

                    break;

                case "Print":
                    listyIterator.Print();

                    break;

                case "HasNext":
                    System.out.println(listyIterator.HasNext());

                    break;

                case "Move":
                    System.out.println(listyIterator.Move());

                    break;


            }


            line = scanner.nextLine();
        }


    }
}
