import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyAPicture {
    public static void main(String[] args) {

        byte[] buffer = new byte[1024];
        try (FileInputStream fileInputStream = new FileInputStream("image.jpg");
             FileOutputStream fileOutputStream = new FileOutputStream("outputForImage")) {

            while (fileInputStream.read(buffer) != -1) {
                fileOutputStream.write(buffer);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
