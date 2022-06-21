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

	public static void reverseWithBitwise(String str)
	{
		char[] arr = str.toCharArray();
		int l = 0, r= arr.length-1;
		while(l<r)
		{
			arr[l]= (char)(arr[l]^arr[r]);
			arr[r]=(char)(arr[l]^arr[r]);
			arr[l]= (char)(arr[l]^arr[r]);
			l++;
			r--;
		}
		System.out.println(new String(arr));
	}

	public static void reverseWords(String s)
	{
		String[] a = s.trim().split(" ");

		int l=0;
		int r=a.length-1;
		while(l<=r){
			String t=a[l];
			a[l]=a[r];
			a[r]=t;
			l++;
			r--;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<a.length-1;i++){
			if(!a[i].trim().equals("")){
				sb.append(a[i]+" ");
			}
		}
		sb.append(a[a.length-1]);
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		reverse("abcdbe");
		reverseWithBitwise("abcdbe");
		reverseWords("the sky is blue");// blue is sky the
	}
}
