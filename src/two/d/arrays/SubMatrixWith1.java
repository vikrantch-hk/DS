package two.d.arrays;

public class SubMatrixWith1 {
static int sizeOfSubMatrix(int[][] a) {
	int[][] s = new int[a.length][a[0].length];
	int max=0;
	for(int i=0;i<a.length;i++) {
		for(int j=0;j<a[0].length;j++) {
			if(i==0||j==0) {
				
				s[i][j]=a[i][j];
			}
			if(i>0&&j>0 && a[i][j]==1) {
				s[i][j]=Math.min(s[i-1][j-1], Math.min(s[i-1][j],s[i][j-1]))+1;
			}
			if(s[i][j]>max) {
				
				max=s[i][j];
			}
		}
	}
	return max;
	
}
public static void main(String[] args) {
	int M[][] = {{0, 1, 1, 0, 1},  
            {1, 1, 0, 1, 0},  
            {0, 1, 1, 1, 0}, 
            {1, 1, 1, 1, 0}, 
            {1, 1, 1, 1, 1}, 
            {0, 0, 0, 0, 0}}; 
	System.out.println(sizeOfSubMatrix(M));
}
}
