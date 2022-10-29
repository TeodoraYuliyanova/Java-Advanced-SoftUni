import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tasks = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] threads = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int integerToKill = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        ArrayDeque<Integer> threadsQueue = new ArrayDeque<>();

        for (int i = 0; i < tasks.length; i++) {
            tasksStack.push(tasks[i]);
        }
        for (int i = 0; i < threads.length; i++) {
            threadsQueue.add(threads[i]);
        }

        while (tasksStack.contains(integerToKill)) {


            int currentThread = threadsQueue.peek();
            int currentTask = tasksStack.peek();

            if (currentTask == integerToKill) {
                tasksStack.pop();
                System.out.printf("Thread with value %d killed task %d%n" , currentThread , currentTask);
                break;
            }

            if (currentThread >= currentTask) {
                threadsQueue.poll();
                tasksStack.pop();
            }

            if (currentTask > currentThread){
                threadsQueue.poll();
            }


        }

        threadsQueue.forEach(e -> System.out.print(e + " "));


    }
}
