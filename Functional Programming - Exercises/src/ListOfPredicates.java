import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> numbersToDivideBy = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        Predicate<Integer> isDivisible = number -> {
            for (Integer numberToDivide : numbersToDivideBy) {
                if (number % numberToDivide != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= n; i++) {

            if (isDivisible.test(i)) {
                System.out.print(i + " ");
            }
        }


    }
}
