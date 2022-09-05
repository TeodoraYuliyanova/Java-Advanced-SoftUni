import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<Character, Integer> charCount = new TreeMap<>();

        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);
            if (charCount.containsKey(symbol)) {
                charCount.put(symbol, charCount.get(symbol) + 1);
            } else {
                charCount.put(symbol, 1);
            }

        }

        for (var element : charCount.entrySet()) {
            System.out.printf("%c: %d time/s%n", element.getKey(), element.getValue());
        }
    }
}
