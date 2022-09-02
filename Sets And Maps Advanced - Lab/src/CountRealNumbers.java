import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> numbersMap = new LinkedHashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            double key = numbers[i];

            if (!numbersMap.containsKey(key)) {
                numbersMap.put(key, 1);
            } else {
                numbersMap.put(key, numbersMap.get(key) + 1);
            }
        }

        numbersMap.entrySet().forEach(e ->
                System.out.printf("%.1f -> %d%n", e.getKey(), e.getValue()));


    }
}
