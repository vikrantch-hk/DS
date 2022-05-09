package cracking.code.interview;

import java.util.Arrays;

public class RemoveDuplicateWithoutExtraSpace {

	public static void removeDuplicate(String str)
	{
		char[] arr= str.toCharArray();
		Arrays.sort(arr);
		int i=0;
		for(int j=1;j<arr.length;j++)
		{
			if(arr[i]!=arr[j])
				arr[++i]=arr[j];
		}
		System.out.println("without duplicate "+new String(arr,0,i+1));
		
	}
	public static void main(String[] args) {
		removeDuplicate("abcdddeefhhhgkkll");
	}
}
