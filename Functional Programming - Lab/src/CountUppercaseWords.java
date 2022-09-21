import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> startsWithUppercase = word -> Character.isUpperCase(word.charAt(0));
        List<String> wordsWithUpperCase = Arrays.stream(scanner.nextLine().split("\\s+")).filter(startsWithUppercase).collect(Collectors.toList());

        System.out.println(wordsWithUpperCase.size());
        System.out.println(String.join(System.lineSeparator() , wordsWithUpperCase));
    }
}
