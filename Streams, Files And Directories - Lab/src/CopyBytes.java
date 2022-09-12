import java.io.*;
import java.util.Scanner;

public class CopyBytes {
    public static void main(String[] args) {

        try (FileInputStream fileInputStream = new FileInputStream("04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt")) {

            PrintWriter printWriter = new PrintWriter("04. Java-Advanced-Files-and-Streams-Lab-Resources/03.CopyBytesOutput.txt");

            int read = fileInputStream.read();
            while (read != -1) {

                if (read == 32) {
                    printWriter.print(" ");
                } else if (read == 10) {
                    printWriter.println();
                } else {
                    printWriter.print(read);
                }


                read = fileInputStream.read();
            }

            printWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
