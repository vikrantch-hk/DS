import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ReverseVowels {
public static String reverseVowels(String s) {

	char[] arr = s.toCharArray();
	String vowels = "";

	for(int i=0;i<arr.length;i++) {
		if(isVowel(arr[i])) {
			vowels+=arr[i];
		}
	}
	
	char[] vowelsArr = vowels.toCharArray();
	int i=0;
	int j=vowels.length()-1;
	while (i<=j) {
		swap(vowelsArr,i,j);
		i++;
		j--;
	}
	
	int l=0;
	for(int k=0;k<arr.length;k++) {
		if(isVowel(arr[k])) {
			arr[k]=vowelsArr[l++];
		}
	}
	return String.valueOf(arr);
}

private static void swap(char[] vowelsArr, int i, int j) {
	char t = vowelsArr[i];
	vowelsArr[i]=vowelsArr[j];
	vowelsArr[j]=t;
	
}

static boolean isVowel(char a) {
	switch (Character.toLowerCase(a)) {
	case 'a':
		return true;
	case 'e':
		return true;
	case 'i':
		return true;
	case 'o':
		return true;
	case 'u':
		return true;

	default:
		return false;
	}
}

public static void main(String[] args) {
	System.out.println(reverseVowels("hello world"));
}
}
