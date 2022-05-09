package two.d.arrays;

// https://stackoverflow.com/questions/726756/print-two-dimensional-array-in-spiral-order
public class SpiralArrayPrint {

	public static void print(int[][] arr) {
		int rowStrt = 0, rowEnd = arr.length - 1, colStrt = 0, colEnd = arr[0].length - 1;

		while(rowStrt<=rowEnd && colStrt<=colEnd)
		{
			// print first row
			for(int i=colStrt;i<=colEnd;i++)
			{
				System.out.print(arr[rowStrt][i]+" ");
			}
			// increment row will start printing last column from second row
			for(int i=rowStrt+1;i<=rowEnd;i++)
			{
				System.out.print(arr[i][colEnd]+" ");
			}
			// decrement colend by 1 
			for(int i=colEnd-1;i>=colStrt;i--)
			{
				System.out.print(arr[rowEnd][i]+" ");
			}
			// decrement rowend by 1
			for(int i=rowEnd-1;i>=rowStrt+1;i--)
			{
				System.out.print(arr[i][colStrt]+" ");
			}
			
			rowStrt++;
			colStrt++;
			rowEnd--;
			colEnd--;
		}
	}

	public static void main(String[] args) {

		int arr[][]=new int[4][3];
		arr[0]=new int[]{1,2,3};
		arr[1]=new int[]{4,5,6};
		arr[2]=new int[]{7,8,9};
		arr[3]=new int[]{10,11,12};
		print(arr);
	}

}
