import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> nameAndEmailMap = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!line.equals("stop")) {

            String name = line;
            String email = scanner.nextLine();

            nameAndEmailMap.put(name, email);

            if (email.endsWith(".us") || email.endsWith(".uk") || email.endsWith(".com")) {
                nameAndEmailMap.remove(name);
            }


            line = scanner.nextLine();
        }

        for (var entry : nameAndEmailMap.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
