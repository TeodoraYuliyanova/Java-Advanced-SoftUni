import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());
        numbers.removeIf(num -> num % 2 != 0);

        String output = numbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(output);

        String output2 = numbers.stream().sorted().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(output2);



    }
}
