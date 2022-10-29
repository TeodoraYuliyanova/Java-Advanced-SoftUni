import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numsMen = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numsWomen = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> menStack = new ArrayDeque<>();
        ArrayDeque<Integer> womenQueue = new ArrayDeque<>();

        for (int i = 0; i < numsMen.length; i++) {
            menStack.push(numsMen[i]);
        }

        for (int i = 0; i < numsWomen.length; i++) {
            womenQueue.add(numsWomen[i]);
        }

        int matches = 0;

        while (!womenQueue.isEmpty() && !menStack.isEmpty()) {

            int woman = womenQueue.peek();
            int man = menStack.peek();

            if (woman <= 0) {
                womenQueue.poll();
                continue;
            }

            if (man <= 0) {
                menStack.pop();
                continue;
            }

            if (man % 25 == 0) {
                menStack.pop();
                menStack.pop();
                continue;
            }

            if (woman % 25 == 0) {
                womenQueue.poll();
                womenQueue.poll();
                continue;
            }

            if (woman == man) {
                womenQueue.poll();
                menStack.pop();
                matches++;

            } else {
                womenQueue.poll();
                menStack.pop();
                menStack.push(man - 2);

            }
        }

        System.out.println("Matches: " + matches);

        if (menStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.println("Males left: " + menStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (womenQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.println("Females left: " + womenQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }
}
