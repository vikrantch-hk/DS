import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class CountWordsInFile {

	public static void count() {

		File file = new File("D:\\node.properties");

		try {
			System.out.println(file.getAbsolutePath());
			Scanner sc = new Scanner(file);
			Map<String, Integer> map = new HashMap<String, Integer>();
			while (sc.hasNextLine())
			/*
			 * Add a call to nextLine or any other Scanner method that'll read
			 * in some input inside the while loop.
			 * 
			 * At the moment you're just repeatedly calling hasNextLine (which
			 * only returns a boolean, it doesn't modify the stream) without
			 * retrieving any input from freader, so if freader initially has
			 * another line within its input hasNextLine will always return true
			 * and your loop is essentially while (true).
			 */
			{

				String[] arr = sc.nextLine().split(" ");

				for (String s : arr) {
					int count = 0;
					if (map.containsKey(s)) {
						count = map.get(s) + 1;
					} else {
						count = 1;
					}
					map.put(s, count);
				}
			}
			sc.close();
			Iterator<Map.Entry<String, Integer>> itr = map.entrySet()
					.iterator();
			while (itr.hasNext()) {
				Map.Entry<String, Integer> entry = itr.next();
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountWordsInFile.count();
	}

}
