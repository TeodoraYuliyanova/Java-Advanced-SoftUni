import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class MergeTwoFiles {
    public static void main(String[] args) throws FileNotFoundException {

        try(Scanner scannerForFirst = new Scanner(new FileReader("04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt"));
            Scanner scannerForSecond = new Scanner(new FileReader("04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt"));
            PrintWriter printWriter = new PrintWriter("outputForMergeTwoFiles.txt")){

            while (scannerForFirst.hasNext()){
                printWriter.println(scannerForFirst.next());
            }

            while (scannerForSecond.hasNext()){
                printWriter.println(scannerForSecond.next());
            }


        }
    }
}
