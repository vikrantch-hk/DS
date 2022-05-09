
package two.d.arrays;
// http://www.geeksforgeeks.org/rotate-matrix-90-degree-without-using-extra-space-set-2/

public class RotateArrayBy90 {

	public static void rotateArr(int[][] input){
		int n = input[0].length;
		int[][] output = new int[n][n];
		
		for(int i=n-1,k=0;i>=0;i--,k++)
		{
			for(int j=0;j<n;j++)
			{
				output[k][j]=input[j][i];
			}
		}
		
		for(int i=0;i<n;i++)
		{
			System.out.println();
			for(int j=0;j<n;j++)
			{
				System.out.print(output[i][j]+" ");
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] input = new int[3][3];
		input[0]=new int[]{1,2,3};
		input[1]=new int[]{4,5,6};
		input[2]=new int[]{7,8,9};
		for(int i=0;i<3;i++)
		{
			System.out.println();
			for(int j=0;j<3;j++)
			{
				System.out.print(input[i][j]+" ");
			}
		}
		rotateArr(input);
	}

}
