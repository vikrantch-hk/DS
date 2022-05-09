import java.util.Arrays;

import javax.lang.model.element.Element;

// http://www.vikasing.com/2010/11/simple-url-shortening-algorithm-in-java.html
/*We have so many url shortening services available today, I am not sure what kind of algorithm they use to shorten a particular url. Given the limitations over the characters which can be used in a url it becomes pretty much obvious that we are limited to 62 alpha numeric chars i.e. [a-z 0-9 A-Z]. 
With 62 chars and a unique string 7 char long we can shorten:
627 = 3,521,614,606,208 urls*/
/*Suppose you have a table with following columns: 
1. unique auto increment id (long), 
2. url (string), 
3. base62 string (string)
Now the trick is that we convert unique id to base62 string not the url, and then the url is mapped to the unique id. For example if we want to shorten the following url:
http://news.xinhuanet.com/english2010/world/2010-11/18/c_13612801.htm
First we need to look for the last unique id in the table then add 1 to it and convert the resulting number to base62. Suppose last unique id was 678544325 now the next id 678544326 will be mapped to the above url and base62 of a 678544326 will be:
45*624+57*623+6*622+23*621+20*620
means a five char url, having following array indexes {45}{57}{6}{23}{20} in
String[] elements = {
                "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o",
                "p","q","r","s","t","u","v","w","x","y","z","1","2","3","4",
                "5","6","7","8","9","0","A","B","C","D","E","F","G","H","I",
                "J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X",
                "Y","Z"
                };*/
/*which will give a base62 string: JVgxu and a shortened url can be http://xyz.com/JVgxu
*/public class URLShortner {
	private static String[] elements = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
			"q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "A",
			"B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z" };

	public static String getShortUrl(int id) {
		StringBuilder shortUrl = new StringBuilder();
		if (id < 62)
			return elements[id];
		else {
			int n = id;
			while (n > 0) {
				shortUrl.append(elements[n % 62]);
				n = n / 62;
			}
		}
		return shortUrl.reverse().toString();
	}

	public static int getLongUrl(String shortUrl) {
		int id = 0;
		for (int i = 0; i < shortUrl.length(); i++) {
			id = id * 62 + Arrays.asList(elements).indexOf(String.valueOf(shortUrl.charAt(i)));
			// decimal = decimal*2+Integer.parseInt(str.charAt(i));// binary to decimal
		}
		return id;
	}

	public static void main(String[] args) {
		System.out.println(getShortUrl(12345));
		System.out.println(getLongUrl("dnh"));
	}

}
