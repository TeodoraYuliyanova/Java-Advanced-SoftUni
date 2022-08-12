import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        ArrayDeque <Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < line.length(); i++) {

            char element = line.charAt(i);

            if (element == '('){

                stack.push(i);


            }else if (element == ')'){

                int lastOpenedIndex = stack.pop();
                String matching = line.substring(lastOpenedIndex , i + 1);
                System.out.println(matching);
            }

        }
    }
}
