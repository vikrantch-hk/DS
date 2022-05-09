import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class FileReader {

	public static void main(String[] args) throws IOException {
		try(Scanner sc = new Scanner(new File("C:\\Users\\vchudhr\\application.yml")))
				{
		while (sc.hasNextLine())
			Files.write(Paths.get("C:\\Users\\vchudhr\\trimmed_application.yml"), sc.nextLine().getBytes(),
					StandardOpenOption.CREATE
					, StandardOpenOption.APPEND);
				}

	}

}
