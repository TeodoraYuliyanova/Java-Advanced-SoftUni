import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] operations = scanner.nextLine().split("\\s+");
        int[] lineOfNumbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int numbersOfElementsToPush = Integer.parseInt(operations[0]);
        int numbersOfElementsToPop = Integer.parseInt(operations[1]);
        int elementToCheckIfPresent = Integer.parseInt(operations[2]);
        ArrayDeque<Integer> numbers = new ArrayDeque<>();


        for (int i = 0; i < numbersOfElementsToPush; i++) {

            numbers.push(lineOfNumbers[i]);
        }

        for (int i = 0; i < numbersOfElementsToPop; i++) {
            numbers.pop();
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
