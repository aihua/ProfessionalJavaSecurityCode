import java.io.*;

public class FileWriteTest {
	public static void main (String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("test.txt");
		fos.write("This is some test text.".getBytes());
		fos.close();
	}
}