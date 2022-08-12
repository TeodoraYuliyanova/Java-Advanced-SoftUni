import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String line = scanner.nextLine();
        ArrayDeque<String> browser = new ArrayDeque<>();

        String currentURL = "blank";

        while (!line.equals("Home")) {

            if (line.equals("back")) {

                if (browser.isEmpty()) {
                    System.out.println("no previous URLs");
                    line = scanner.nextLine();
                    continue;
                } else {
                    currentURL = browser.pop();

                }


            } else {
                if (!currentURL.equals("blank")) {
                    browser.push(currentURL);
                }


                currentURL = line;


            }


            System.out.println(currentURL);
            line = scanner.nextLine();
        }
    }
}
