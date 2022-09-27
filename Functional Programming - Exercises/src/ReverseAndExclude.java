import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());

        numbers.removeIf(num -> num % n == 0);
        Collections.reverse(numbers);
        Consumer<Integer> printer = num -> System.out.print(num + " ");
        for (Integer number : numbers) {
            printer.accept(number);
        }
    }
}
