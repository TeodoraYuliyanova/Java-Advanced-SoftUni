package GenericBoxOfInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box box = new Box();

        for (int i = 0; i < n; i++) {
            box.add(Integer.parseInt(scanner.nextLine()));
        }
        System.out.println(box);
    }
}
