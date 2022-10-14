package GenericSwapMethodInteger;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int  n = Integer.parseInt(scanner.nextLine());
        Box box = new Box();

        for (int i = 0; i < n; i++) {
            box.add(Integer.parseInt(scanner.nextLine()));
        }

        int [] indicesToSwap = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int firstIndex = indicesToSwap[0];
        int secondIndex = indicesToSwap[1];

        box.swap(firstIndex,secondIndex);

        System.out.println(box);
    }
}
