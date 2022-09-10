import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {

        try(FileInputStream fileInputStream = new FileInputStream("04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt")){

            int read = fileInputStream.read();
            while (read != -1){

                System.out.printf("%s" + " " , Integer.toBinaryString(read));


                read = fileInputStream.read();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
