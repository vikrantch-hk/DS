
// page-358 problem-11
public class CancelAdjacentSameItems {

	public static void doCancel(String s) {
		char[] arr = s.toCharArray();
		int j=0;
		for(int i=1;i<arr.length;i++)
		{
			while(arr[i]==arr[j] && j>0)
			{
				i++;
				j--;
			}
			arr[++j]=arr[i];
		}
		System.out.println("new array is");
		for(int i=0;i<=j;i++) {
			System.out.print(arr[i]);
		}
	}
	
	public static void main(String[] args) {
		doCancel("ABCCBCBA");
	}
	
	
}
