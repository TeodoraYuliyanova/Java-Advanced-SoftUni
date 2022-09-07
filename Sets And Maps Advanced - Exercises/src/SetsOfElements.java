import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> firstNumbersSet = new LinkedHashSet<>();
        Set<String> secondNumbersSet = new LinkedHashSet<>();

        String [] line = scanner.nextLine().split(" ");
        int sizeForFirst = Integer.parseInt(line[0]);
        int sizeForSecond = Integer.parseInt(line[1]);

        for (int i = 0; i < sizeForFirst; i++) {
            String numToAdd = scanner.nextLine();
            firstNumbersSet.add(numToAdd);
        }

        for (int i = 0; i < sizeForSecond; i++) {
            String numToAdd = scanner.nextLine();
            secondNumbersSet.add(numToAdd);
        }


        firstNumbersSet.retainAll(secondNumbersSet);
        System.out.println(String.join(" ", firstNumbersSet));
    }
}
