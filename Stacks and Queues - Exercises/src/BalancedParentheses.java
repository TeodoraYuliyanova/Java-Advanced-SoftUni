import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean isBalanced = true;

        for (int i = 0; i < line.length(); i++) {

            char element = line.charAt(i);
            if (element == '(' || element == '{' || element == '[') {
                stack.push(element);
            } else {
                if (stack.isEmpty()){
                    isBalanced = false;
                    break;
                }
                char lastOpenBracket = stack.pop();
                if (element == ')' && lastOpenBracket != '(') {
                    isBalanced = false;
                } else if (element == '}' && lastOpenBracket != '{') {
                    isBalanced = false;
                } else if (element == ']' && lastOpenBracket != '[') {
                    isBalanced = false;
                }

            }
        }

        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }
}
