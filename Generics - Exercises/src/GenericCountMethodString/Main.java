package GenericCountMethodString;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box <String> box = new Box();

        for (int i = 0; i < n; i++) {
            box.add(scanner.nextLine());
        }

        String elementToCompare = scanner.nextLine();

        System.out.println(box.countGreaterThan(elementToCompare));
    }
}
