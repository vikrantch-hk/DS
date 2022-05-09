package cracking.code.interview;

public class ReverseString {
	
	public static void reverse(String str)
	{
		char[] arr = str.toCharArray();
		int l = 0, r= arr.length-1;
		while(l<=r)
		{
			char temp = arr[l];
			arr[l]= arr[r];
			arr[r]=temp;
			l++;
			r--;
		}
		System.out.println(new String(arr));
	}

	public static void main(String[] args) {
		reverse("abcdb");
	}
}