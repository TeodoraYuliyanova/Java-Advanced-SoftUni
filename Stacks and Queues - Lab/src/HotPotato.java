import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //NE E RESHENA PRAVILNO !!!!!

        String [] namesOfChildren = scanner.nextLine().split("\\s+");
        ArrayDeque <String> queue = new ArrayDeque<>();
        for (String name : namesOfChildren){
            queue.offer(name);
        }

        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 1; i <= n; i++) {

            if (queue.size() > 1) {

                queue.offer(queue.poll());
                System.out.println("Removed " + queue.poll());
            }
        }

            System.out.println("Last is " + queue.peek());


    }
}
