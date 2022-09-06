import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phoneBook = new LinkedHashMap<>();

        String line = scanner.nextLine();

        while (!line.equals("search")) {

            String[] info = line.split("-");
            String name = info[0];
            String number = info[1];

            phoneBook.put(name, number);


            line = scanner.nextLine();
        }

        line = scanner.nextLine();
        while (!line.equals("stop")) {

            String nameToSearch = line;

            if (!phoneBook.containsKey(nameToSearch)) {
                System.out.printf("Contact %s does not exist.%n", nameToSearch);
            } else {
                System.out.printf("%s -> %s%n", nameToSearch, phoneBook.get(nameToSearch));
            }


            line = scanner.nextLine();
        }

    }
}
