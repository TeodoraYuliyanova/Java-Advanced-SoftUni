import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);




        //NE E RESHENA DOKRAI!!!!!!!
        String line = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();
        String currentURl = "blank";
        String forwardURL = "blank";


        ArrayDeque <String> forward = new ArrayDeque<>();

        while (!line.equals("Home")) {


            if (line.equals("back")) {

                if (stack.isEmpty()) {
                    System.out.println("no previous URLs");
                    line = scanner.nextLine();
                    continue;
                } else {
                    forwardURL = currentURl;
                    currentURl = stack.pop();

                }


            } else if (line.equals("forward")) {

                if (forwardURL.equals("blank")){
                    System.out.println("no next URLs");
                    line = scanner.nextLine();
                    continue;
                }else {
                    System.out.println(forwardURL);
                    line = scanner.nextLine();
                    continue;
                }


            } else {
                if (!currentURl.equals("blank")) {
                    stack.push(currentURl);
                }

                currentURl = line;
                forwardURL = "blank";
            }


            System.out.println(currentURl);
            line = scanner.nextLine();
        }
    }
}
