import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> function = (int [] arr) -> {
            int smallestNumber = Integer.MAX_VALUE;
            for (int num : arr) {
                if (num < smallestNumber){
                smallestNumber = num;
                }
            }
            return smallestNumber;

        };

        System.out.println(function.apply(numbers));

    }
}
