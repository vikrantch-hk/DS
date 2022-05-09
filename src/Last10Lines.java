import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Last10Lines {

	// https://stackoverflow.com/questions/9465269/how-to-read-last-5-lines-of-a-txt-file-into-java
	public static void readLast10LinesOfALargeFile(String path) throws FileNotFoundException {
		File file = new File(path);
		try (Scanner sc = new Scanner(file)) {
			Queue<String> list = new LinkedList<String>();
			//LinkedList<String> list = new LinkedList<String>();
			while (sc.hasNextLine()) {
				list.add(sc.nextLine());
				if (list.size() > 10)
					list.poll();
			}
			list.forEach(s -> System.out.println(s));
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		try {
			readLast10LinesOfALargeFile("C:\\Users\\vchudhr\\application.yml");//Desktop\\list.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
