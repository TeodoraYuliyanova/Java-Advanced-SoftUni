import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) {


        try (FileInputStream fileInputStream = new FileInputStream("04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt");
             FileOutputStream fileOutputStream = new FileOutputStream("04. Java-Advanced-Files-and-Streams-Lab-Resources/02.WriteToFileOutput.txt")) {

            int read = fileInputStream.read();
            while (read != -1) {

                if (read != '?' && read != '!' && read != '.' && read != ',') {
                    fileOutputStream.write(read);

                }

                read = fileInputStream.read();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
