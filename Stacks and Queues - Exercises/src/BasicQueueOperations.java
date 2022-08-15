import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] operations = scanner.nextLine().split("\\s+");
        int[] lineOfNumbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int numbersOfElementsToAdd = Integer.parseInt(operations[0]);
        int numbersOfElementsToPoll = Integer.parseInt(operations[1]);
        int elementToCheckIfPresent = Integer.parseInt(operations[2]);

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < numbersOfElementsToAdd; i++) {

            numbers.offer(lineOfNumbers[i]);
        }

        for (int i = 0; i < numbersOfElementsToPoll; i++) {
            numbers.poll();
        }


        if (numbers.isEmpty()){
            System.out.println("0");
        }else {
            if (numbers.contains(elementToCheckIfPresent)) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(numbers));
            }
        }

    }
}
