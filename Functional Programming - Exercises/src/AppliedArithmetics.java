import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        UnaryOperator<List<Integer>> addOperator = numbersList -> numbersList.stream().map(number -> number + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtractOperator = numberList -> numberList.stream().map(number -> number - 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiplyOperator = numberList -> numberList.stream().map(number -> number * 2).collect(Collectors.toList());
        Consumer<Integer> printer = number -> System.out.printf("%d ", number);

        String line = scanner.nextLine();
        while (!line.equals("end")) {

            switch (line) {

                case "add":
                    numbers = addOperator.apply(numbers);
                    break;

                case "subtract":
                    numbers = subtractOperator.apply(numbers);
                    break;

                case "multiply":
                    numbers = multiplyOperator.apply(numbers);
                    break;

                case "print":
                    numbers.forEach(printer);
                    System.out.println();
                    break;

                default:
                    System.out.println("NO SUCH COMMAND!");
            }


            line = scanner.nextLine();
        }
    }


}

