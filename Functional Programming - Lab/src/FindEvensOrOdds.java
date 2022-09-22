import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] range = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();
        int low = range[0];
        int up = range[1];

        System.out.println(IntStream.rangeClosed(low, up).boxed().filter(getPredicate(command)).map(String::valueOf).collect(Collectors.joining(" ")));

    }

    private static Predicate<Integer> getPredicate(String command) {

        if (command.equals("odd")){
            return  p -> p % 2 != 0;
        }

        return p -> p % 2 == 0;
    }


}
