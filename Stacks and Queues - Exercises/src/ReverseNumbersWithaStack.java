import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithaStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int [] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque <Integer> reversedNums = new ArrayDeque<>();
        for (Integer num : numbers){
            reversedNums.push(num);
        }

        for(Integer number : reversedNums){
            System.out.print(number + " ");
        }
    }
}
