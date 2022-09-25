import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> findSmallest = numbersList -> {
            int smallestNumber = Integer.MAX_VALUE;
            for (Integer number : numbersList) {
                if (number < smallestNumber) {
                    smallestNumber = number;
                }
            }
            return smallestNumber;
        };

        int index = numbers.lastIndexOf(findSmallest.apply(numbers));
        System.out.println(index);
    }
}
