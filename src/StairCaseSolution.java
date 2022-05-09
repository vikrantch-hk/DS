// https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
public class StairCaseSolution {
	// to reach n stair lets say m=3
	// total ways = (ways to reach (n-1) step+1) +
	//				(ways to reach (n-2) step+2)+
	//				(ways to reach (n-3) step+3)
	// res[n]=res[n-1]+res[n-2]+res[n-3]
	public static int waysToReach(int n, int m) {
		int res[] = new int[n+1];
		res[0]=1;
		res[1]=1;
		for(int i=2;i<=n;i++) {
			res[i]=0;
			for(int j=1;j<=m && j<=i;j++) {
				res[i]+=res[i-j];
			}
		}
		
		return res[n];
	}
// complexity o(n*m)
	public static void main(String[] args) {
		int s = 4, m = 2; 
        System.out.println("Number of ways = "
                           + waysToReach(s, m)); 
	}
}
